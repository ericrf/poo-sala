package edu.fae.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
public class ImagemController {

	public void save(FileUploadEvent event) throws IOException {
		FacesMessage msg = new FacesMessage("Success! ", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/");

		File file = new File(path + "/images/" + event.getFile().getFileName());
		InputStream is = event.getFile().getInputstream();
		OutputStream out = new FileOutputStream(file);
		byte buf[] = new byte[1024];
		int len;
		while ((len = is.read(buf)) > 0)
			out.write(buf, 0, len);
		is.close();
		out.close();
	}
}
