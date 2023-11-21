package Models.EstructuraDeDatos;

import Models.Nodo_Producto;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;

public class PilaStack_Producto {

    public Stack<Nodo_Producto> pilaP;

    public PilaStack_Producto() {
        pilaP = new Stack<>();
    }

    public void setPushPelicula(Nodo_Producto p) {
        int pos = pilaP.indexOf(p);
        if (pos == -1) {
            pilaP.push(p);
            JOptionPane.showMessageDialog(null, "Pelicula registrada!");
        } else {
            JOptionPane.showMessageDialog(null, "La pelicula ya se encuentra registrada!");
        }
    }

    public Nodo_Producto getPeliId(int id) {
        Nodo_Producto aux = new Nodo_Producto();
        int i = 0;
        while (i < pilaP.size()) {
            aux = (Nodo_Producto) pilaP.get(i);
            if (aux.getId() == id) {
                return aux;
            }
            i++;
        }
        aux = null;
        return aux;
    }

    public void setPopPeliId(int id) {
        Nodo_Producto aux = null;
        if (!pilaP.empty()) {
            aux = getPeliId(id);
            if ((aux != null) && (pilaP.remove(aux))) {
                JOptionPane.showMessageDialog(null, "Pelicula eliminada!");
            } else {
                JOptionPane.showMessageDialog(null, "La pelicula no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aun no se han registrado peliculas!");
        }
    }

    public PilaStack_Producto getClonar() {
        PilaStack_Producto caux = new PilaStack_Producto();
        int i;
        Nodo_Producto aux = null;
        if (this.pilaP == null) {
            return null;
        } else {
            for (i = 0; i < pilaP.size(); i++) {
                aux = (Nodo_Producto) pilaP.get(i);
                caux.pilaP.add(i, aux);
            }
            return caux;
        }
    }

    @SuppressWarnings({"unchecked", "unchecked"})
    public void mostrarProximosEstrenos(Stack<Nodo_Producto> estrenos, int cantidad, TableView<Nodo_Producto> tabla) throws IOException {
        if (estrenos.isEmpty()) {
            System.out.println("La pila de estrenos está vacía.");
            return;
        }

        ObservableList<Nodo_Producto> data = FXCollections.observableArrayList();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\ArchivosTxt\\proximosEstrenos.txt"))) {
            int mostrados = 0;

            writer.append("                     LISTADO DE PELICULAS POR ESTRENAR                    " + "\n" + "\n");
            String headers = "IdPelicula      Nombre        Duracion       Categoria          Valor Boleta\n";
            writer.append(headers);

            while (mostrados < cantidad) {

                if (!estrenos.isEmpty()) {
                    Nodo_Producto producto = estrenos.pop();
                    data.add(producto);

                    String info2 = "   " + producto.getId() + "          "
                            + producto.getMarca() + "     "
                            + producto.getTipo() + "        "
                            + producto.getPrecio() + "\n";
                    writer.write(info2);
                    mostrados++;
                }
            }
            JOptionPane.showMessageDialog(null, "Se han mostrado y guardado en el archivo los próximos estrenos.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        tabla.setItems(data);

    }

    @SuppressWarnings({"unchecked", "unchecked"})
    public void mostrarEstrenosAntiguos(Stack<Nodo_Producto> estrenos, int cantidad, TableView<Nodo_Producto> tabla) throws IOException {
        if (estrenos.isEmpty()) {
            System.out.println("La pila de estrenos está vacía.");
            return;
        }
        Stack<Nodo_Producto> pilaInvertida = new Stack<>();
        ObservableList<Nodo_Producto> data = FXCollections.observableArrayList();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\ArchivosTxt\\estrenosAntiguos.txt"))) {
            int mostrados = 0;

            writer.append("                     LISTADO DE PELICULAS ANTIGUAS                    " + "\n" + "\n");
            String headers = "IdPelicula      Nombre        Duracion       Categoria          Valor Boleta\n";
            writer.append(headers);

            while (!estrenos.isEmpty()) {
                pilaInvertida.push(estrenos.pop());
            }

            while (mostrados < cantidad) {

                if (!pilaInvertida.isEmpty()) {
                    Nodo_Producto producto = pilaInvertida.pop();
                    data.add(producto);

                    String info2 = "   " + producto.getId() + "          "
                            + producto.getMarca() + "     "
                            + producto.getTipo() + "        "
                            + producto.getPrecio() + "\n";
                    writer.write(info2);
                    mostrados++;
                }
            }

            JOptionPane.showMessageDialog(null, "Se han mostrado y guardado en el archivo los estrenos antiguos.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
        tabla.setItems(data);
    }

    public void eliminar(Stack<Nodo_Producto> pila, int id) {
        Stack<Nodo_Producto> temp = new Stack<>();

        while (!pila.isEmpty()) {
            Nodo_Producto producto = pila.pop();
            if (producto.getId() != id) {
                temp.push(producto);
            }
        }
        while (!temp.isEmpty()) {
            pila.push(temp.pop());
        }
    }

    public void ExportarListaTXT(String ubi, Stack<Nodo_Producto> pOri) {
        String info = "LISTADO DE PELICULAS - TABLA" + "\n" + "\n";
        @SuppressWarnings("unchecked")
        Stack<Nodo_Producto> paux = (Stack<Nodo_Producto>) pOri.clone();

        if (!paux.isEmpty()) {

            try {

                try (PrintWriter writer = new PrintWriter(ubi + "DCM ListaPelis.txt", "UTF-8")) {
                    if (!paux.isEmpty()) {
                        writer.write(info);
                        String headers = "IdPelicula      Nombre        Duracion       Categoria          Valor Boleta\n";
                        writer.write(headers);

                        for (Nodo_Producto producto : pOri) {
                            String info2 = "   " + producto + "          "
                                    + producto + "     "
                                    + producto + "        "
                                    + producto + "               "
                                    + producto + "\n";
                            writer.write(info2);
                        }

                    }

                }
                System.out.println("Exportación exitosa - Datos guardados..!");
            } catch (Exception e) {
                System.out.println("Error al guardar datos en el archivo: " + e.getMessage());
            }
        }

    }

    public void ExportarListaPDF(String ubi, Stack<Nodo_Producto> pOri) throws FileNotFoundException, IOException {
        String info = "                                      LISTADO DE COMPRAS - TABLA                          " + "\n" + "\n";
        @SuppressWarnings("unchecked")
        Stack<Nodo_Producto> paux = (Stack<Nodo_Producto>) pOri.clone();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(ubi + "DCM Historial_Compras.pdf"));
            document.open();

            BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font1 = new Font(bf1, 14);

            BaseFont bf2 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font2 = new Font(bf2, 12);

            BaseFont bf3 = BaseFont.createFont(BaseFont.HELVETICA_BOLDOBLIQUE, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font3 = new Font(bf3, 12);

            PdfPTable table = new PdfPTable(5);

            String[] headers = {"IdProducto", "Marca", "Tipo", "Precio"};

            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell();
                headerCell.setPhrase(new com.itextpdf.text.Phrase(header, font3));
                table.addCell(headerCell);
            }

            for (Nodo_Producto producto : pOri) {
                table.addCell(new Paragraph(String.valueOf(""), font2));
                table.addCell(new Paragraph("", font2));
                table.addCell(new Paragraph(String.valueOf(""), font2));
                table.addCell(new Paragraph("", font2));
                table.addCell(new Paragraph(String.valueOf(""), font2));
            }
            Paragraph parag = new Paragraph(info, font1);
            parag.setAlignment(Element.ALIGN_CENTER);
            document.add(parag);
            document.add(table);

            document.close();

            System.out.println("¡Lista exportada a PDF correctamente!");

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
