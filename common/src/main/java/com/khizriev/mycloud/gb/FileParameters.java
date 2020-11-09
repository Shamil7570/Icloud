package com.khizriev.mycloud.gb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;


/**
 * Класс собирающий информацию о трех параметрах файла:
 * 1. Имя файла
 * 2. Размер файла
 * 3. Дата последней модификации файла
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileParameters implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Long size;
	private String date;
	
	
	
//	public FileParameters(String fileName, String fileStoragePath) {
//		Path path = Paths.get(name + fileStoragePath);
//		this.name = fileName;
//		try {
//			this.size = Files.size(path);
//			BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
//			this.date = basicFileAttributes.lastModifiedTime().toString();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public FileParameters(Path path) {
		this.name = path.toFile().getName();
		try {
			this.size = Files.size(path);
			BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
			this.date = basicFileAttributes.lastModifiedTime().toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
