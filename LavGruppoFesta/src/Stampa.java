/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nicolabonomi
 */
import java.awt.*;
import java.awt.print.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Stampa implements Printable {
    private String nomeFesta;
    private int nScontrino;
    private float totale;

 public Stampa(String nome,int nScon,float tot) throws PrinterException{
   PrinterJob pj = PrinterJob.getPrinterJob();
   nomeFesta=nome;
   nScontrino=nScon;
   totale=tot;
   pj.printDialog();

   pj.setPrintable(this);
   pj.print();
 }

 public int print(Graphics g, PageFormat pf, int page)
                        throws PrinterException {

   if (page > 0) {
      return NO_SUCH_PAGE;
   }

   Graphics2D g2d = (Graphics2D) g;
   g2d.translate(pf.getImageableX(), pf.getImageableY());


   int y = 100;
  FileReader ff = null;
  BufferedReader fIN = null;
 
  String s;
  StringTokenizer st;
  

  try{
      ff = new FileReader("ordineScontrino.csv");
      fIN = new BufferedReader(ff);
  } catch(IOException e){
      System.out.println(e);
      System.exit(1);
  }
  try{
      s = fIN.readLine();
      g2d.drawString(nomeFesta,130,50);
      while(s != null){
          if (!s.isEmpty()){
              st = new StringTokenizer(s,";");
              while(st.hasMoreTokens()){
                  
                  String nome = st.nextToken();
                  String qta = st.nextToken();
                  String prezzo = st.nextToken();
                  
                  g2d.drawString(nome, 50, y);
                  g2d.drawString(qta, 150, y);
                  g2d.drawString(prezzo+" €", 330, y);

                  y += 45;
                  s = fIN.readLine();
              }
          }    
      }
      y+=55;
      g2d.drawString("Totale: "+String.valueOf(totale)+" €", 50, y);
      y+=50;
      g2d.drawString("Scontrino N° "+String.valueOf(nScontrino), 50, y);
      y+=50;      
      g2d.drawString("Data: "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 50, y);
  }catch(Exception e){
      System.out.println("Errore nella lettura del file");
      System.exit(1);
  }
  try{
      ff.close();
  } catch(IOException e){
      System.out.println("Errore nella chiusura del file");
      System.exit(1);
  }
   return PAGE_EXISTS;
 }
}
