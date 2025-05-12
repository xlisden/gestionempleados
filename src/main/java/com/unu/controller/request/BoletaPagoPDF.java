package com.unu.controller.request;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class BoletaPagoPDF {

    public static void generarBoleta(String rutaSalida) {
        try {
            Document documento = new Document(PageSize.A4, 36, 36, 54, 36);
            PdfWriter.getInstance(documento, new FileOutputStream(rutaSalida));
            documento.open();

            Font negrita = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Font normal = new Font(Font.FontFamily.HELVETICA, 10);

            // Encabezado
            Paragraph encabezado = new Paragraph("BOLETA DE PAGO\n\n", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            encabezado.setAlignment(Element.ALIGN_CENTER);
            documento.add(encabezado);

            PdfPTable infoGeneral = new PdfPTable(2);
            infoGeneral.setWidthPercentage(100);
            infoGeneral.addCell(celda("Del 11/1/2007 Al 11/30/2007", negrita,1, PdfPCell.ALIGN_LEFT));
            infoGeneral.addCell(celda("razon social de la empresa", negrita,1, PdfPCell.ALIGN_RIGHT));
            documento.add(infoGeneral);

            documento.add(new Paragraph("Direccion:\nRUC:\n\n", normal));

            // Datos del empleado
            PdfPTable datos = new PdfPTable(4);
            datos.setWidthPercentage(100);
            datos.addCell(celda("CÓDIGO: 002", normal));
            datos.addCell(celda("NOMBRE:", normal));
            datos.addCell(celda("CARGO:", normal));
            datos.addCell(celda("DOC ID: AUTOGEN", normal));
            datos.addCell(celda("HABER BÁSICO: 6,000.00", normal));
            datos.addCell(celda("CATEG: EMPLEADO", normal));
            datos.addCell(celda("F. PENSIÓN: AFP INTEGRA", normal));
            datos.addCell(celda("C.U.S.P.P.: 580220COBOA8", normal));
            documento.add(datos);
            documento.add(Chunk.NEWLINE);

            // Remuneraciones y descuentos
            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new int[]{1, 1});

            // Columna izquierda - Remuneraciones
            PdfPTable remuneraciones = new PdfPTable(2);
            remuneraciones.addCell(celda("REMUNERACIONES", negrita, 2, Element.ALIGN_CENTER));
            remuneraciones.addCell(celda("HABER BÁSICO", normal));
            remuneraciones.addCell(celda("6,000.00", normal));
            remuneraciones.addCell(celda("ASIGNACION FAM.", normal));
            remuneraciones.addCell(celda("0.00", normal));
            remuneraciones.addCell(celda("GRATIFICACION", normal));
            remuneraciones.addCell(celda("0.00", normal));
            remuneraciones.addCell(celda("DOMINICAL", normal));
            remuneraciones.addCell(celda("0.00", normal));
            tabla.addCell(remuneraciones);

            // Columna derecha - Descuentos
            PdfPTable descuentos = new PdfPTable(2);
            descuentos.addCell(celda("DESCUENTOS", negrita, 2, Element.ALIGN_CENTER));
            descuentos.addCell(celda("AFP FONDO: 10%", normal));
            descuentos.addCell(celda("600.00", normal));
            descuentos.addCell(celda("AFP COMISION: 1.80%", normal));
            descuentos.addCell(celda("108.00", normal));
            descuentos.addCell(celda("AFP SEGURO: 0.88%", normal));
            descuentos.addCell(celda("52.80", normal));
            descuentos.addCell(celda("5TA. CATEGORIA", normal));
            descuentos.addCell(celda("944.88", normal));
            descuentos.addCell(celda("SEGURO PARTICULAR", normal));
            descuentos.addCell(celda("386.00", normal));
            tabla.addCell(descuentos);

            documento.add(tabla);
            documento.add(Chunk.NEWLINE);

            // Totales
            PdfPTable totales = new PdfPTable(2);
            totales.setWidthPercentage(100);
            totales.addCell(celda("TOTAL REMUNERACION", negrita));
            totales.addCell(celda("TOTAL DESCUENTOS", negrita));
            totales.addCell(celda("6,000.00", normal));
            totales.addCell(celda("2,091.68", normal));
            documento.add(totales);

            documento.add(new Paragraph("\nSan Isidro, 30 de Noviembre de 2007", normal));
            documento.add(new Paragraph("\n\n____________________\nEMPLEADOR", normal));

            documento.close();
            System.out.println("PDF generado correctamente en: " + rutaSalida);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PdfPCell celda(String texto, Font fuente) {
        return celda(texto, fuente, 1, Element.ALIGN_LEFT);
    }

    private static PdfPCell celda(String texto, Font fuente, int colspan, int alineacion) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, fuente));
        celda.setColspan(colspan);
        celda.setHorizontalAlignment(alineacion);
        celda.setBorder(Rectangle.NO_BORDER);
        return celda;
    }

    public static void main(String[] args) {
        generarBoleta("boleta_pago.pdf");
    }
}
