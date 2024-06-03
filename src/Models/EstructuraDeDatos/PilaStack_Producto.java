package Models.EstructuraDeDatos;

import Models.Nodos.Nodo_Producto;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class PilaStack_Producto {

    private final Stack<Nodo_Producto> pilaPM;
    private final Stack<Nodo_Producto> pilaPF;
    private final Stack<Nodo_Producto> pilaPH;

    public PilaStack_Producto() {
        pilaPM = new Stack<>();
        pilaPF = new Stack<>();
        pilaPH = new Stack<>();
    }

    public Stack<Nodo_Producto> getPilaPM() {
        return pilaPM;
    }

    public Stack<Nodo_Producto> getPilaPF() {
        return pilaPF;
    }

    public Stack<Nodo_Producto> getPilaPH() {
        return pilaPH;
    }

    //Metodos PilaP Masculinos
    public void setPushProducto(Nodo_Producto p) {
        int pos = pilaPM.indexOf(p);
        if (pos == -1) {
            pilaPM.push(p);
        } else {
            System.out.println("Ya se encontraba registrado el producto");
        }
    }

    public Nodo_Producto getProId(int id) {
        Nodo_Producto aux = new Nodo_Producto();
        int i = 0;
        while (i < pilaPM.size()) {
            aux = pilaPM.get(i);
            if (aux.getId() == id) {
                return aux;
            }
            i++;
        }
        aux = null;
        return aux;
    }

    public void setPopProducId(int id) {
        Nodo_Producto aux = null;
        if (!pilaPM.empty()) {
            aux = getProId(id);
            if ((aux != null) && (pilaPM.remove(aux))) {
                JOptionPane.showMessageDialog(null, "Producto eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aun no se han registrado procutos!");
        }
    }

    public PilaStack_Producto getClonar() {
        PilaStack_Producto caux = new PilaStack_Producto();
        int i;
        Nodo_Producto aux = null;
        if (this.pilaPM == null) {
            return null;
        } else {
            for (i = 0; i < pilaPM.size(); i++) {
                aux = pilaPM.get(i);
                caux.pilaPM.add(i, aux);
            }
            return caux;
        }
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

    //Metodos pilaP Femeninos
    public void setPushProducto_F(Nodo_Producto p) {
        int pos = pilaPF.indexOf(p);
        if (pos == -1) {
            pilaPF.push(p);
        } else {
            System.out.println("Ya se encontraba registrado el producto");
        }
    }

    public Nodo_Producto getProId_F(int id) {
        Nodo_Producto aux = new Nodo_Producto();
        int i = 0;
        while (i < pilaPF.size()) {
            aux = pilaPF.get(i);
            if (aux.getId() == id) {
                return aux;
            }
            i++;
        }
        aux = null;
        return aux;
    }

    public void setPopProducId_F(int id) {
        Nodo_Producto aux = null;
        if (!pilaPF.empty()) {
            aux = getProId(id);
            if ((aux != null) && (pilaPF.remove(aux))) {
                JOptionPane.showMessageDialog(null, "Producto eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aun no se han registrado procutos!");
        }
    }

    public PilaStack_Producto getClonar_F() {
        PilaStack_Producto caux = new PilaStack_Producto();
        int i;
        Nodo_Producto aux = null;
        if (this.pilaPF == null) {
            return null;
        } else {
            for (i = 0; i < pilaPF.size(); i++) {
                aux = pilaPF.get(i);
                caux.pilaPF.add(i, aux);
            }
            return caux;
        }
    }

    public void eliminar_F(Stack<Nodo_Producto> pila, int id) {
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

    //Metodos Pila Historial 
    public void setPushProducto_H(Nodo_Producto p) {
        int pos = pilaPH.indexOf(p);
        if (pos == -1) {
            pilaPH.push(p);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Confirmación");
            a.setContentText("Compra registrada!");
            a.show();
        } else {
            System.out.println("El producto ya se encuentra registrado!");
        }
    }

    public void setPushProducto_HC(Nodo_Producto p) {
        int pos = pilaPH.indexOf(p);
        if (pos == -1) {
            pilaPH.push(p);
        } else {
            System.out.println("El producto ya se encuentra registrado!");
        }
    }

    public Nodo_Producto getProId_H(int id) {
        Nodo_Producto aux = new Nodo_Producto();
        int i = 0;
        while (i < pilaPH.size()) {
            aux = pilaPH.get(i);
            if (aux.getId() == id) {
                return aux;
            }
            i++;
        }
        aux = null;
        return aux;
    }

    public void setPopProducId_H(int id) {
        Nodo_Producto aux = null;
        if (!pilaPH.empty()) {
            aux = getProId(id);
            if ((aux != null) && (pilaPH.remove(aux))) {
                JOptionPane.showMessageDialog(null, "Producto eliminado!");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aun no se han registrado procutos!");
        }
    }

    public PilaStack_Producto getClonar_H() {
        PilaStack_Producto caux = new PilaStack_Producto();
        int i;
        Nodo_Producto aux = null;
        if (this.pilaPH == null) {
            return null;
        } else {
            for (i = 0; i < pilaPH.size(); i++) {
                aux = pilaPH.get(i);
                caux.pilaPH.add(i, aux);
            }
            return caux;
        }
    }

    public void eliminar_H(Stack<Nodo_Producto> pila, int id) {
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

    private PdfPCell createParagraph(String content, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setMinimumHeight(font.getSize() * 1.5f);
        return cell;
    }

    public void ExportarHistorialComprasPDF(String ubi, Stack<Nodo_Producto> pOri) throws FileNotFoundException, IOException {
        String info = "                                      LISTADO DE COMPRAS - TABLA                          " + "\n" + "\n";
        @SuppressWarnings("unchecked")
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

            PdfPTable table = new PdfPTable(6);

            String[] headers = {"IdProducto", "Marca", "Tipo", "Precio", "Comprador", "Fecha Compra"};

            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell();
                headerCell.setPhrase(new Phrase(header, font3));
                table.addCell(headerCell);
            }

            for (Nodo_Producto producto : pOri) {
                table.addCell(createParagraph(String.valueOf(producto.getId()), font2));
                table.addCell(createParagraph(producto.getMarca(), font2));
                table.addCell(createParagraph(producto.getTipo(), font2));
                table.addCell(createParagraph(String.valueOf(producto.getPrecio()), font2));
                table.addCell(createParagraph(producto.getComprador(), font2));
                table.addCell(createParagraph(String.valueOf(producto.getFechaCompra()), font2));
            }
            Paragraph parag = new Paragraph(info, font1);
            parag.setAlignment(Element.ALIGN_CENTER);
            document.add(parag);
            document.add(table);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ExportarCatalogoMaPDF(String ubi, Stack<Nodo_Producto> pOri) throws FileNotFoundException, IOException {
        String info = "                CATALOGO MASCULINO" + "\n" + "\n";
        @SuppressWarnings("unchecked")
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(ubi + "SIMON'S CATALOGO MASCULINO.pdf"));
            document.open();

            BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font1 = new Font(bf1, 14);

            BaseFont bf2 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font2 = new Font(bf2, 12);

            BaseFont bf3 = BaseFont.createFont(BaseFont.HELVETICA_BOLDOBLIQUE, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font3 = new Font(bf3, 12);

            PdfPTable table = new PdfPTable(2);

            String[] headers = {"Modelo", "Descripcion"};

            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell();
                headerCell.setPhrase(new com.itextpdf.text.Phrase(header, font3));
                table.addCell(headerCell);
            }

            for (Nodo_Producto producto : pOri) {
                String descripcion = "\n\nMaraca: " + producto.getMarca() + "\n\n"
                        + "Tipo: " + producto.getTipo() + "\n\n"
                        + "Precio: " + String.valueOf(producto.getPrecio()) + "\n\n"
                        + "Tallas: " + producto.getTalla();

                PdfPCell celda = new PdfPCell();

                String imagePath = producto.getUrl_Imag();
                File imageFile = new File(imagePath);

                if (imageFile.exists()) {
                    try {
                        Image imagen = Image.getInstance(imagePath);
                        celda.addElement(imagen);
                        table.addCell(celda);
                    } catch (IOException | DocumentException e) {
                    }
                } else {
                    System.out.println("La ruta de la imagen no existe: " + imagePath);
                }

                table.addCell(new Paragraph(descripcion, font2));
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

    public void cargarProductos_MaDesdeArchivo() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Productos_M.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaPM.isEmpty()) {
                pilaPM.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String url = atributos[0];
                String marca = atributos[1];
                String tipo = atributos[2];
                double precio = Double.parseDouble(atributos[3]);
                String genero = atributos[4];

                Nodo_Producto producto = new Nodo_Producto();
                producto.setUrl_Imag(url);
                producto.setMarca(marca);
                producto.setTipo(tipo);
                producto.setPrecio((float) precio);
                producto.setGenero(genero);
                producto.setTalla("XS, S, M, L, XL");

                setPushProducto(producto);
            }

            System.out.println("Datos cargados correctamente desde archivo de productos M.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de clientes: " + e.getMessage());
        }
    }

    public void ExportarCatalogoFePDF(String ubi, Stack<Nodo_Producto> pOri) throws FileNotFoundException, IOException {
        String info = "                CATALOGO FEMENINO" + "\n" + "\n";
        @SuppressWarnings("unchecked")
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(ubi + "SIMON'S CATALOGO FEMENINO.pdf"));
            document.open();

            BaseFont bf1 = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font1 = new Font(bf1, 14);

            BaseFont bf2 = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font2 = new Font(bf2, 12);

            BaseFont bf3 = BaseFont.createFont(BaseFont.HELVETICA_BOLDOBLIQUE, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            Font font3 = new Font(bf3, 12);

            PdfPTable table = new PdfPTable(2);

            String[] headers = {"Modelo", "Descripcion"};

            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell();
                headerCell.setPhrase(new com.itextpdf.text.Phrase(header, font3));
                table.addCell(headerCell);
            }

            for (Nodo_Producto producto : pOri) {
                String descripcion = "\n\nMaraca: " + producto.getMarca() + "\n\n"
                        + "Tipo: " + producto.getTipo() + "\n\n"
                        + "Precio: " + String.valueOf(producto.getPrecio()) + "\n\n"
                        + "Tallas: " + producto.getTalla();

                PdfPCell celda = new PdfPCell();

                String imagePath = producto.getUrl_Imag();
                File imageFile = new File(imagePath);

                if (imageFile.exists()) {
                    try {
                        Image imagen = Image.getInstance(imagePath);
                        celda.addElement(imagen);
                        table.addCell(celda);
                    } catch (IOException | DocumentException e) {
                    }
                } else {
                    System.out.println("La ruta de la imagen no existe: " + imagePath);
                }

                table.addCell(new Paragraph(descripcion, font2));
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

    public void cargarProductos_FeDesdeArchivo() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Productos_F.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;

            if (!pilaPF.isEmpty()) {
                pilaPF.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                String url = atributos[0];
                String marca = atributos[1];
                String tipo = atributos[2];
                double precio = Double.parseDouble(atributos[3]);
                String genero = atributos[4];

                Nodo_Producto producto = new Nodo_Producto();
                producto.setUrl_Imag(url);
                producto.setMarca(marca);
                producto.setTipo(tipo);
                producto.setPrecio((float) precio);
                producto.setGenero(genero);
                producto.setTalla("XS, S, M, L, XL");

                setPushProducto_F(producto);
            }

            System.out.println("Datos cargados correctamente desde archivo de productos F.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de clientes: " + e.getMessage());
        }
    }

    public void guardarDatosEnArchivoCompras(Stack<Nodo_Producto> pilaPH) {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Compras.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            Stack<Nodo_Producto> proAux = pilaPH;

            for (Nodo_Producto producto : proAux) {
                writer.write(producto.getId() + ", ");
                writer.write(producto.getMarca() + ", ");
                writer.write(producto.getTipo() + ", ");
                writer.write(producto.getPrecio() + ", ");
                writer.write(producto.getComprador() + ", ");
                writer.write(String.valueOf(producto.getFechaCompra()));
                writer.newLine();
            }

            System.out.println("Datos guardados correctamente en el archivo de compras.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo de compras: " + e.getMessage());
        }
    }

    public void cargarDatosDesdeArchivoCompras() {

        String direccion = System.getProperty("user.dir") + "\\src\\ArchivosBase_TXT\\Archivo_Compras.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo.toFile()))) {

            String linea;
            if (!pilaPH.isEmpty()) {
                pilaPH.clear();
            }
            while ((linea = reader.readLine()) != null) {

                String[] atributos = linea.split(", ");

                Integer id = Integer.valueOf(atributos[0]);
                String marca = atributos[1];
                String tipo = atributos[2];
                Float precio = Float.valueOf(atributos[3]);
                String comprador = atributos[4];
                DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                LocalDateTime fechaCompra = LocalDateTime.parse(atributos[5], formatter);

                Nodo_Producto producto = new Nodo_Producto(id, marca, tipo, precio, comprador, fechaCompra);

                setPushProducto_HC(producto);
            }

            System.out.println("Datos cargados correctamente desde archivo de compras.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo de compras: " + e.getMessage());
        }
    }

}
