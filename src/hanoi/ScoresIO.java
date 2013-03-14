package hanoi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ScoresIO {

    private static final String RUTA = "src/files/score.txt";

    public static void escribir(java.util.List<Puntaje> puntajes) {

        File file;
        FileWriter fileWriter = null;
        BufferedWriter out = null;

        try {

            file = new File(RUTA);
            fileWriter = new FileWriter(file);
            out = new BufferedWriter(fileWriter);

            for (Puntaje puntaje : puntajes) {

                out.write(puntaje.getNombre());
                out.newLine();
                out.write(Integer.toString(puntaje.getMovimientos()));
                out.newLine();
                out.write(Long.toString(puntaje.getTiempo()));
                out.newLine();
                out.write(Integer.toString(puntaje.getNumDiscos()));
                out.newLine();
                
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
            }

            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
            }

        }
    }

    public static java.util.List<Puntaje> leer(int numerDeDiscosDeseado, boolean porMovimientos) {

        BufferedReader br = null;
        FileReader fileWriter = null;
        File file;

        java.util.List<Puntaje> puntuaciones = new LinkedList<Puntaje>();

        try {

            file = new File(RUTA);
            fileWriter = new FileReader(file);
            br = new BufferedReader(fileWriter);

            String nombre;
            while ((nombre = br.readLine()) != null) {

                int movimientos = Integer.parseInt(br.readLine());
                long tiempo = Long.parseLong(br.readLine());
                int numeroDeDiscos = Integer.parseInt(br.readLine());
                if (numeroDeDiscos == numerDeDiscosDeseado) {
                    puntuaciones.add(new Puntaje(nombre, movimientos, tiempo, numeroDeDiscos, porMovimientos));
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
            }

            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
            }

        }

        return puntuaciones;
    }
}
