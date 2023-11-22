package Models.EstructuraDeDatos;

import Models.Nodos.Nodo_Producto;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;
import javax.swing.JOptionPane;

public class PilaStack_Producto {

    public Stack<Nodo_Producto> pilaP;

    public PilaStack_Producto() {
        pilaP = new Stack<>();
    }

    public void setPushProducto(Nodo_Producto p) {
        int pos = pilaP.indexOf(p);
        if (pos == -1) {
            pilaP.push(p);
            JOptionPane.showMessageDialog(null, "Procucto registrado!");
        } else {
            JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado!");
        }
    }

    public Nodo_Producto getProId(int id) {
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
            aux = getProId(id);
            if ((aux != null) && (pilaP.remove(aux))) {
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

    public void ExportarPilaPDF(String ubi, Stack<Nodo_Producto> pOri) throws FileNotFoundException, IOException {
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

            String[] headers = {"IdProducto", "Marca", "Tipo", "Precio", "Genero", "Talla"};

            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell();
                headerCell.setPhrase(new com.itextpdf.text.Phrase(header, font3));
                table.addCell(headerCell);
            }

            for (Nodo_Producto producto : pOri) {
                table.addCell(new Paragraph(String.valueOf(producto.getId()), font2));
                table.addCell(new Paragraph(producto.getMarca(), font2));
                table.addCell(new Paragraph(producto.getTipo(), font2));
                table.addCell(new Paragraph(String.valueOf(producto.getPrecio()), font2));
                table.addCell(new Paragraph(producto.getTalla(), font2));
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
