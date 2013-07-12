package br.com.ubiquesoftlib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import android.util.Log;

public class Compactar {

	/**
	 * Compacta determindado arquivo ou diretorio para o arquivo ZIP
	 * especificado
	 * 
	 * @param input O arquivo ou diretorio de entrada
	 * @param output O arquivo ZIP de sai­da
	 */
	public static void compress(final File input, final File output) {
		
		try 
		{
			if (!input.exists()) {
				Log.i("compress", input.getName() + " nao existe!");
			}
			if (output.exists()) {
				if (output.isDirectory()) {					
					Log.i("compress", output.getAbsolutePath() + "\" nao a um arquivo!");
				}
			} else {
				final File parent = output.getParentFile();
				if (parent != null) {
					parent.mkdirs();
				}
				output.createNewFile();
			}
			final ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(output));
			zip.setLevel(Deflater.BEST_COMPRESSION);
			compress("", input, zip);
			zip.finish();
			zip.flush();
			zip.close();
			
		} catch (Exception e) 
		{
			Logs.LogError("Compress", e.toString());
		}
	}

	/**
	 * Extrai um arquivo ZIP para o diretório especificado
	 * 
	 * @param input O arquivo ZIP de entrada
	 * @param output O diretorio de saida
	 */
	public static void extract(final File input, final File output) 
	{
		try 
		{			
			if (input.exists()) {
				if (input.isDirectory()) {
					Log.i("extract", input.getAbsolutePath() + "arquivo não existe!");
				}
			} else {
				Log.i("extract", input.getAbsolutePath() + "diretorio existe!");
			}
			if (output.exists()) {
				if (output.isFile()) {
					Log.i("extract", output.getAbsolutePath() + "diretorio a existe!");
				}
			}
			final ZipFile zip = new ZipFile(input);
			extract(zip, output);
			zip.close();
			
		} catch (Exception e) {
			Logs.LogError("extract", e.toString());
		}
	}

	// Adiciona determinado arquivo ao ZIP
	private static void compress(final String caminho, final File arquivo,
			final ZipOutputStream saida) throws IOException {
		final boolean dir = arquivo.isDirectory();
		final String nome = arquivo.getName();
		final ZipEntry elemento = new ZipEntry(caminho + '/' + nome + (dir ? "/" : ""));
		elemento.setSize(arquivo.length());
		elemento.setTime(arquivo.lastModified());
		saida.putNextEntry(elemento);
		if (dir) {
			final File[] arquivos = arquivo.listFiles();
			for (int i = 0; i < arquivos.length; i++) {
				// recursivamente adiciona outro arquivo ao ZIP
				compress(caminho + '/' + nome, arquivos[i], saida);
			}
		} else {
			final FileInputStream entrada = new FileInputStream(arquivo);
			copy(entrada, saida);
			entrada.close();
		}
	}

	// Copia o conteudo do stream de entrada para o stream de saída
	private static void copy(final InputStream in, final OutputStream out)
			throws IOException {
		final int n = 4096;
		final byte[] b = new byte[n];
		for (int r = -1; (r = in.read(b, 0, n)) != -1; out.write(b, 0, r)) {
		}
		out.flush();
	}

	// Retira determinado elemento do arquivo ZIP
	private static void extract(final ZipFile zip, final File pasta)
			throws IOException {
		InputStream entrada = null;
		OutputStream saida = null;
		String nome = null;
		File arquivo = null;
		ZipEntry elemento = null;
		final Enumeration<?> elementos = zip.entries();
		while (elementos.hasMoreElements()) {
			elemento = (ZipEntry) elementos.nextElement();
			nome = elemento.getName();
			nome = nome.replace('/', File.separatorChar);
			nome = nome.replace('\\', File.separatorChar);
			arquivo = new File(pasta, nome);
			if (elemento.isDirectory()) {
				arquivo.mkdirs();
			} else {
				if (!arquivo.exists()) {
					final File parent = arquivo.getParentFile();
					if (parent != null) {
						parent.mkdirs();
					}
					arquivo.createNewFile();
				}
				saida = new FileOutputStream(arquivo);
				entrada = zip.getInputStream(elemento);
				copy(entrada, saida);
				saida.flush();
				saida.close();
				entrada.close();
			}
			arquivo.setLastModified(elemento.getTime());
		}
	}
}
