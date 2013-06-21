package br.com.ubiquesoflib.alertaMensagem;

import java.util.LinkedList;
import java.util.Queue;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * 
 * @author Evgeny Shishkin
 * 
 */
class ToastAlertaMensagemManager extends Handler {

    private static final int MESSAGE_DISPLAY = 0xc2007;
    private static final int MESSAGE_ADD_VIEW = 0xc20074dd;
    private static final int MESSAGE_REMOVE = 0xc2007de1;

    private static ToastAlertaMensagemManager mInstance;

    private Queue<ToastAlertaMensagem> msgQueue;
    private Animation inAnimation, outAnimation;

    private ToastAlertaMensagemManager() {
        msgQueue = new LinkedList<ToastAlertaMensagem>();
    }

    /**
     * @return The currently used instance of the {@link ToastAlertaMensagemManager}.
     */
    static synchronized ToastAlertaMensagemManager getInstance() {
        if (mInstance == null) {
            mInstance = new ToastAlertaMensagemManager();
        }
        return mInstance;
    }

    /**
     * Inserts a {@link ToastAlertaMensagem} to be displayed.
     * 
     * @param ToastAlertaMensagem
     */
    void add(ToastAlertaMensagem appMsg) {
        msgQueue.add(appMsg);
        if (inAnimation == null) {
            inAnimation = AnimationUtils.loadAnimation(appMsg.getActivity(),
                    android.R.anim.fade_in);
        }
        if (outAnimation == null) {
            outAnimation = AnimationUtils.loadAnimation(appMsg.getActivity(),
                    android.R.anim.fade_out);
        }
        displayMsg();
    }

    /**
     * Removes all {@link ToastAlertaMensagem} from the queue.
     */
    void clearMsg(ToastAlertaMensagem appMsg) {
        msgQueue.remove(appMsg);
    }

    /**
     * Removes all {@link ToastAlertaMensagem} from the queue.
     */
    void clearAllMsg() {
        if (msgQueue != null) {
            msgQueue.clear();
        }
        removeMessages(MESSAGE_DISPLAY);
        removeMessages(MESSAGE_ADD_VIEW);
        removeMessages(MESSAGE_REMOVE);
    }

    /**
     * Displays the next {@link ToastAlertaMensagem} within the queue.
     */
    private void displayMsg() {
        if (msgQueue.isEmpty()) {
            return;
        }
        // First peek whether the AppMsg is being displayed.
        final ToastAlertaMensagem appMsg = msgQueue.peek();
        // If the activity is null we throw away the AppMsg.
        if (appMsg.getActivity() == null) {
            msgQueue.poll();
        }
        final Message msg;
        if (!appMsg.isShowing()) {
            // Display the AppMsg
            msg = obtainMessage(MESSAGE_ADD_VIEW);
            msg.obj = appMsg;
            sendMessage(msg);
        } else {
            msg = obtainMessage(MESSAGE_DISPLAY);
            sendMessageDelayed(msg, appMsg.getDuration()
                    + inAnimation.getDuration() + outAnimation.getDuration());
        }
    }

    /**
     * Removes the {@link ToastAlertaMensagem}'s view after it's display duration.
     * 
     * @param appMsg The {@link ToastAlertaMensagem} added to a {@link ViewGroup} and should be removed.s
     */
    private void removeMsg(final ToastAlertaMensagem appMsg) {
        ViewGroup parent = ((ViewGroup) appMsg.getView().getParent());
        if (parent != null) {
            appMsg.getView().startAnimation(outAnimation);
            // Remove the AppMsg from the queue.
            msgQueue.poll();
            // Remove the AppMsg from the view's parent.
            parent.removeView(appMsg.getView());
            Message msg = obtainMessage(MESSAGE_DISPLAY);
            sendMessage(msg);
        }
    }

    private void addMsgToView(ToastAlertaMensagem appMsg) {
        if (appMsg.getView().getParent() == null) {
            appMsg.getActivity().addContentView(
                    appMsg.getView(),
                    appMsg.getLayoutParams());
        }
        appMsg.getView().startAnimation(inAnimation);
        final Message msg = obtainMessage(MESSAGE_REMOVE);
        msg.obj = appMsg;
        sendMessageDelayed(msg, appMsg.getDuration());
    }

    @Override
    public void handleMessage(Message msg) {
        final ToastAlertaMensagem appMsg;
        switch (msg.what) {
            case MESSAGE_DISPLAY:
                displayMsg();
                break;
            case MESSAGE_ADD_VIEW:
                appMsg = (ToastAlertaMensagem) msg.obj;
                addMsgToView(appMsg);
                break;
            case MESSAGE_REMOVE:
                appMsg = (ToastAlertaMensagem) msg.obj;
                removeMsg(appMsg);
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }
}