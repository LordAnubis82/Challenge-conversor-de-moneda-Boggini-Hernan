package com.hernanboggini.convertor;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Archivo {
    private List<String> lista = new ArrayList<>();

    public void listado() {

        try {
            FileOutputStream fos = new FileOutputStream("lista.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leerLista() {
        File file = new File("lista.dat");

        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                lista = (List<String>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException();
            }
        }

    }

    public void addLista(String s) {
        LocalDateTime ldt = LocalDateTime.now();
        LocalTime localTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String fechaHora = " " + ldt.getDayOfMonth() + "/ " + ldt.getMonth() + " / "
                + ldt.getYear() + " Hora:" + localTime.format(formatter);
        lista.add(0, s + fechaHora);
        if (lista.size() > 12) lista.remove(lista.size() - 1);

    }

    public List<String> getLista() {
        return lista;
    }

}
