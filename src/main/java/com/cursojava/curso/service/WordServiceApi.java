package com.cursojava.curso.service;

import com.cursojava.curso.models.Asientos;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public interface WordServiceApi {

    void createWord(String title, String imagePath, String fileName) throws IOException, InvalidFormatException;
    void gaurdarInfoUsuario(Asientos asientos);
}
