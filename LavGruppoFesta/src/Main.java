
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author nicolabonomi
 */
public class Main  extends javax.swing.JFrame  {
    int nScont=0;
    int contMod1=0;
    int contMod2=0;
    float incSerata=0;
    float aperturaCassa=0;
    Resoconto riepilogoRisto= new Resoconto("Ristorante"); //hashmap per andare a riepilogare le quantità vendute
    Resoconto riepilogoBar= new Resoconto("Bar");
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null); //POSIZIONA AL CENTRO DI OGNI SCHERMO 
        jDialog1.setLocationRelativeTo(null); //POSIZIONA AL CENTRO DI OGNI SCHERMO AL JDIALOG DI MODIFICA
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); //NON SI PUO' CHIUDERE NORMALMENTE
        float apCassa = 0; // Numero di default dell' apertura di cassa
        String input; 
        boolean inputValido = false;
        while (!inputValido) {
            input = JOptionPane.showInputDialog(null, "Inserisci i soldi dell'apertura di cassa:","Apertura di Cassa",JOptionPane.QUESTION_MESSAGE); //option pane per la richiesta dell'apertura di cassa
            if(input==null){ //se l'input è null chiudi il programma
                System.exit(0);
            }
            try {
                // Prova a convertire l'input in un numero
                apCassa = Float.parseFloat(input);
                inputValido = true;
            } catch (NumberFormatException e) {
                // Se l'input non è un numero valido, mostra un messaggio di errore
                JOptionPane.showMessageDialog(null, "Input non valido. Inserisci un numero valido.");
            }
        }
        incSerata=apCassa; //setta la mia variabile globale relativa all'incasso della serata che essendo iniziale è uguale al numero acquisito precedentemente
        aperturaCassa=apCassa; //setto l'apertura di cassa con il numero acquisito prima 
        jLabel3.setText("APERTURA CASSA: "+apCassa+" €"); // setta la label 
        jLabel6.setText("CASSA ATTUALE: "+apCassa+" €"); //setta la label
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(formatter); 
        jLabel2.setText(formattedDate); //Metti la data di oggi formattata nella label
        int contTab1=0;
        int contTab2=0;
        FileReader ff = null;
        BufferedReader fIN = null;
        String s;
        StringTokenizer st;
        int qta=0;
        String nome="";
        float prezzo=0;
        //TABELLA 1 LETTURA
        try{
            ff = new FileReader("tabella1.csv"); //Inizio lettura della mia tabella salvata in csv
            fIN = new BufferedReader(ff);
        } catch(IOException e){
            System.out.println(e);
            System.exit(1);
        }
        try{
            s = fIN.readLine();
            while(s != null){
                if (!s.isEmpty()){
                    st = new StringTokenizer(s,";");
                    while(st.hasMoreTokens()){
                        nome = st.nextToken();
                        prezzo = Float.parseFloat(st.nextToken());
                        //s = fIN.readLine();
                    }
                    if (contTab1 < jTable1.getRowCount()) {
                        jTable1.setValueAt(nome, contTab1, 1);
                        jTable1.setValueAt(prezzo, contTab1,2);
                    } else {
                        DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); //se il mio contatore è maggiore creo nuove linee nella tabella
                        model.addRow(new Object[]{null,nome, prezzo});
                    }
                    contTab1++;
                    s = fIN.readLine();
                }    
            }
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
        //TABELLA2 LETTURA
        try{
            ff = new FileReader("tabella2.csv");
            fIN = new BufferedReader(ff);
        } catch(IOException e){
            System.out.println(e);
            System.exit(1);
        }
        try{
            s = fIN.readLine();
            while(s != null){
                if (!s.isEmpty()){
                    st = new StringTokenizer(s,";");
                    while(st.hasMoreTokens()){
                        nome = st.nextToken();
                        prezzo = Float.parseFloat(st.nextToken());
                    }
                    if (contTab2 < jTable2.getRowCount()) {
                        jTable2.setValueAt(nome, contTab2, 1);
                        jTable2.setValueAt(prezzo, contTab2,2);
                    } else { //SE IL MIO CONTATORE E' MAGGIORE CREO NUOVE LINEE NELLA TABELLA
                        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                        model.addRow(new Object[]{null,nome, prezzo});
                    }
                    contTab2++;
                    s = fIN.readLine();
                }    
            }
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
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jDialog1.setMinimumSize(new java.awt.Dimension(500, 400));
        jDialog1.setSize(new java.awt.Dimension(700, 400));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MODIFICA IN MENU' / BAR");
        jDialog1.getContentPane().add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RISTORANTE", "PREZZO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setShowGrid(true);
        jScrollPane3.setViewportView(jTable3);

        jPanel4.add(jScrollPane3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BAR", "PREZZO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable4.setShowGrid(true);
        jScrollPane4.setViewportView(jTable4);

        jPanel4.add(jScrollPane4);

        jDialog1.getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        jButton3.setText("CONFERMA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton3, java.awt.BorderLayout.PAGE_END);

        jPanel5.setLayout(new java.awt.GridLayout(6, 1));

        jLabel5.setText("NOME:");
        jPanel5.add(jLabel5);
        jPanel5.add(jTextField1);

        jLabel7.setText("PREZZO:");
        jPanel5.add(jLabel7);
        jPanel5.add(jTextField2);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("BAR");
        jPanel6.add(jRadioButton2);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("RISTORANTE");
        jPanel6.add(jRadioButton3);

        jPanel5.add(jPanel6);

        jButton6.setText("AGGIUNGI");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);

        jDialog1.getContentPane().add(jPanel5, java.awt.BorderLayout.LINE_END);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 550));

        jPanel3.setLayout(new java.awt.GridLayout(2, 2));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APERTURA CASSA:");
        jLabel3.setToolTipText("Indica il valore in € dell'apertura di cassa a inizio serata");
        jPanel3.add(jLabel3);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CASSA ATTUALE:");
        jLabel6.setToolTipText("Indica il valore in € dei soldi presenti in cassa");
        jPanel3.add(jLabel6);

        jButton1.setText("EVADI ORDINE");
        jButton1.setToolTipText("Evadi l'ordine e procedi alla stampa dello scontrino");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("MODIFICA / AGGIUNGI PRODOTTO");
        jButton2.setToolTipText("Modifica le componenti delle tabelle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "QTA'.", "RISTORANTE", "€"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "QTA'.", "BAR", "€"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jButton5.setText("SALVA TABELLE");
        jButton5.setToolTipText("Salva le modifiche apportate alle tabelle in modo tale da riaverle");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("FESTA DEL CASONCELLO");
        jPanel2.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabel2);

        jButton4.setText("CHIUDI SERATA");
        jButton4.setToolTipText("Chiudi definitvamente la serata");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ArrayList<String> acquisti= new ArrayList(); //mi serve per l'anteprima dello scontrino in txt
        ArrayList<Ordine> acquisti2= new ArrayList(); //mi serve per la stampa dello scontrino 
        acquisti.add(String.format("%-20s%-30s%-10s", "QUANTIT\u00C0", "PRODOTTO", "PREZZO")); //mi serve come intestazione per l'anteprima del mio scontrino
        float totale = 0;
        for (int row = 0; row < jTable1.getRowCount(); row++) { //vado a controllare ogni quantità di ogni riga nella mia tabella 1
            Object quantita = jTable1.getValueAt(row, 0); //prendo i miei valori come oggetto in modo da poter andare a verificare se sono null
            Object valorePrezzo = jTable1.getValueAt(row, 2);
            if (quantita instanceof Integer && valorePrezzo instanceof Float) { //se i valori sono accettabili
                int quant = (int) quantita;
                float prezzo = (float) valorePrezzo;
                if(quant>0){ //se la quantità è maggiore di 0, aggiungimi tutte le cose agli array list e hasmap adibiti al contenimento delle varie informazioni
                    ResocontoProdotti prodotto = new ResocontoProdotti(quant,(String)jTable1.getValueAt(row, 1)); //creo un nuovo oggetto prodotto 
                    if (riepilogoRisto.contieneOggetto((String)jTable1.getValueAt(row, 1))) { //vado a controllare se è già presente nella hashmap
                        ResocontoProdotti prodottoEsistente = riepilogoRisto.menu.get((String)jTable1.getValueAt(row, 1));
                        prodottoEsistente.quant += quant; //se esiste già sommo le quantità della serata
                    } else { //altrimenti creo una nuova istanza della classe ResocontoProdotti e aggiungo un oggetto alla hasmap
                        ResocontoProdotti nuovoProdotto = new ResocontoProdotti(quant, (String)jTable1.getValueAt(row, 1));
                        riepilogoRisto.aggiungiOggetto((String)jTable1.getValueAt(row, 1), nuovoProdotto);
                    }
                    String acq = String.format("%-20s%-30s%-10s", quant, jTable1.getValueAt(row, 1), prezzo); //vado ad aggiungere questa stringa che mi serve per l'anteprima dello scontrino
                    acquisti.add(acq); //lo aggiungo al suo array list
                    Ordine o=new Ordine(quant,(String)jTable1.getValueAt(row, 1),prezzo); //creo un oggetto ordine che mi serve per creare successivamente il mio csv
                    acquisti2.add(o); //lo aggiungo al suo array list
                    totale += quant * prezzo;  //aggiungo al totale dell'ordine la quantità per il prezzo                  
                }
            }
        }
        //ripeto le stesse cose con la tabella del bar
        for (int row = 0; row < jTable2.getRowCount(); row++) {
            Object quantita = jTable2.getValueAt(row, 0);
            Object valorePrezzo = jTable2.getValueAt(row, 2);
            if (quantita instanceof Integer && valorePrezzo instanceof Float) {
                int quant = (int) quantita;
                float prezzo = (float) valorePrezzo;
                if(quant>0){
                    ResocontoProdotti prodotto = new ResocontoProdotti(quant,(String)jTable2.getValueAt(row, 1));
                    if (riepilogoBar.contieneOggetto((String)jTable2.getValueAt(row, 1))) {
                        ResocontoProdotti prodottoEsistente = riepilogoBar.menu.get((String)jTable2.getValueAt(row, 1));
                        prodottoEsistente.quant += quant;
                    } else {
                        ResocontoProdotti nuovoProdotto = new ResocontoProdotti(quant, (String)jTable2.getValueAt(row, 1));
                        riepilogoBar.aggiungiOggetto((String)jTable2.getValueAt(row, 1), nuovoProdotto);
                    }
                    String acq = String.format("%-20s%-30s%-10s", quant, jTable2.getValueAt(row, 1), prezzo);
                    acquisti.add(acq);
                    Ordine o=new Ordine(quant,(String)jTable2.getValueAt(row, 1),prezzo);
                    acquisti2.add(o);
                    totale += quant * prezzo;                   
                }
            }
        }
        //Se ho fatto almeno un'acquisto
        if(acquisti.size()>1){
            //SCRITTURA SU FILE DI TESTO PER ANTEPRIMA GRAFICA SCONTRINO
            try (PrintWriter scrivi = new PrintWriter(new FileWriter("scontrino.txt"))) {
                scrivi.println(jLabel1.getText());
                scrivi.println(" ");
                scrivi.println(" ");    
                for (String linea : acquisti) {
                    scrivi.println(linea);
                    scrivi.println(" ");                    
                }
                scrivi.println(" ");            
                scrivi.println("Totale: €" + totale);
                scrivi.println(" ");    
                scrivi.println("Scontrino N°: " + ++nScont);
                scrivi.println(" ");
                scrivi.println("Data: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
                //apro il mio scontrino salvato in rxt
                File file = new File("scontrino.txt");
                if (file.exists()) {
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Il file 'scontrino.txt' non esiste.");
                }            
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Si è verificato un errore durante il salvataggio dello scontrino.", "Errore", JOptionPane.ERROR_MESSAGE);
            }
            //scontrino su csv
            FileWriter f = null;
            PrintWriter fOUT = null;
            try{
                f = new FileWriter("ordineScontrino.csv");
                fOUT = new PrintWriter(f);
            }catch (IOException e){
                System.exit(1);
            }
            fOUT.println("QTA'" + ";" + "PRODOTTO" + ";" + "PREZZO");
            Iterator<Ordine> iterator = acquisti2.iterator();
            while(iterator.hasNext()){
                Ordine o=(Ordine) iterator.next();
                fOUT.println(o.quant+";"+o.nome+";"+o.prezzo);
            }
            fOUT.flush();
            try{
                f.close();
            } catch(IOException e){
                System.exit(1);
            }
            //stampa con la classe apposita
            try {
                Stampa st = new Stampa(jLabel1.getText(),nScont,totale);
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(this, "Si è verificato un errore durante la stampa.", "Errore", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            incSerata+=totale; //aggiungo il totale dello scontrino alla serata
            jLabel6.setText("CASSA ATTUALE: "+incSerata+" €");//modifico la label
            DefaultTableModel modelloTabella1 = (DefaultTableModel) jTable1.getModel();
            DefaultTableModel modelloTabella2 = (DefaultTableModel) jTable2.getModel();
            int righeTabella1 = modelloTabella1.getRowCount(); //resetto la tabella 1
            for (int i = 0; i < righeTabella1; i++) {
                modelloTabella1.setValueAt(null, i, 0);
            }
            int righeTabella2 = modelloTabella2.getRowCount(); //resetto la tabella 2
            for (int i = 0; i < righeTabella2; i++) {
                modelloTabella2.setValueAt(null, i, 0); 
            }
        }else{
            JOptionPane.showMessageDialog(this, "Non sono stati inseriti elementi.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (int row = 0; row < jTable1.getRowCount()+contMod1; row++) { //aggiungi le righe alle tabelle di modifica copiandole da quella del main
            Object nome=jTable1.getValueAt(row, 1);
            Object prezzo=jTable1.getValueAt(row, 2);
            if(nome!=null && prezzo!=null){
                String nomeString=(String)nome;
                float prezzoF=(float)prezzo;
                if (row < jTable3.getRowCount()) { //se il numero della riga supera le righe della seconda tabella aggiungine altre
                    jTable3.setValueAt(nomeString, row, 0);
                    jTable3.setValueAt(prezzoF, row,1);
                } else {
                    model = (DefaultTableModel) jTable3.getModel();
                    model.addRow(new Object[]{nomeString, prezzo});
                }
            }
        }
        DefaultTableModel model2 = (DefaultTableModel) jTable4.getModel();
        model2.setRowCount(0);
        for (int row = 0; row < jTable2.getRowCount()+contMod2; row++) { //esegui le stesse operazioni della prima tabella ma andando a modificare le tabelle
            Object nome=jTable2.getValueAt(row, 1);
            Object prezzo=jTable2.getValueAt(row, 2);
            if(nome!=null && prezzo!=null){
                String nomeString=(String)nome;
                float prezzoF=(float)prezzo;
                if (row < jTable4.getRowCount()) { //se il numero della riga supera le righe della seconda tabella aggiungine altre
                    jTable4.setValueAt(nomeString, row, 0);
                    jTable4.setValueAt(prezzoF, row,1);
                } else {
                    model2 = (DefaultTableModel) jTable4.getModel();
                    model2.addRow(new Object[]{nomeString, prezzoF});
                }
            }
        }     
        jDialog1.setVisible(true); //RENDI VISIBILE IL JDIALOG
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int n=JOptionPane.showConfirmDialog(this,"Sicuro di voler uscire?","Uscita dal programma",JOptionPane.YES_NO_OPTION);
        DefaultTableModel tabella = (DefaultTableModel) jTable2.getModel();
        if(n==JOptionPane.YES_OPTION){ //Se sono sicuro di chiudere il programma
            File file = new File("incassiSerate.csv");    //stampo il mio incasso della serata su csv
            boolean fileEsiste = file.exists();
            FileWriter f = null;
            PrintWriter fOUT = null;
            try{
                f = new FileWriter("incassiSerate.csv",true);
                fOUT = new PrintWriter(f);

            } catch (IOException e){
                System.exit(1);
            }
            if (!fileEsiste) { //se il file viene creato per la prima volta stampa l'intestazione
                fOUT.println("Data;AperturaCassa;ChiusuraCassa;IncassoSerata;Scontrini");
            }
            fOUT.println(jLabel2.getText()+ ";" + aperturaCassa + ";" + incSerata+";"+(incSerata-aperturaCassa)+";"+nScont); //stampa le informazioni
            fOUT.flush();
            try{
                f.close();
            } catch(IOException e){
                System.exit(1);
            }
            //SALVO LE QUANTITA su file csv
            FileWriter f1 = null;
            PrintWriter fOUT1 = null;
            try{
                f1 = new FileWriter("riepilogo.csv",true);
                fOUT1 = new PrintWriter(f1);

            } catch (IOException e){
                System.exit(1);
            }
            fOUT1.println(jLabel2.getText());
            for (String codice: riepilogoRisto.menu.keySet()) { //utilizzo la mia hashmap
                ResocontoProdotti ogg = riepilogoRisto.menu.get(codice);
                fOUT1.println(ogg.prod + ";" + ogg.quant );
            }
            for (String codice: riepilogoBar.menu.keySet()) {
                ResocontoProdotti ogg = riepilogoBar.menu.get(codice);
                fOUT1.println(ogg.prod + ";" + ogg.quant );
            }           
            fOUT1.flush();
            try{
                f1.close();
            } catch(IOException e){
                System.exit(1);
            }
            System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean trovato = false;
        char errore=';';
        for (int i = 0; i < jTable3.getRowCount(); i++) {
           String nome = (String) jTable3.getValueAt(i, 0);
           if ((nome.contains(Character.toString(errore)))) {
               trovato = true;
               break;
           }
        }
        if (!trovato) {
           for (int i = 0; i < jTable4.getRowCount(); i++) {
               String nome = (String) jTable4.getValueAt(i, 0);
               if (nome.contains(Character.toString(errore))) {
                   trovato = true;
                   break;
               }
           }
        }
        if (!trovato) {
           DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
           model.setRowCount(0);
           for (int row = 0; row < jTable3.getRowCount(); row++) {
               Object nomeS = jTable3.getValueAt(row, 0);
               Object prezzoOggetto = jTable3.getValueAt(row, 1);
               if (nomeS != null && prezzoOggetto != null) {
                   String nome = (String) nomeS;
                   float prezzo = (Float) prezzoOggetto;
                   model.addRow(new Object[]{null, nome, prezzo});
               }
           }
           DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
           model2.setRowCount(0);
           for (int row = 0; row < jTable4.getRowCount(); row++) {
               Object nomeS = jTable4.getValueAt(row, 0);
               Object prezzoOggetto = jTable4.getValueAt(row, 1);
               if (nomeS != null && prezzoOggetto != null) {
                   String nome = (String) nomeS;
                   float prezzo = (Float) prezzoOggetto;
                   model2.addRow(new Object[]{null, nome, prezzo});
               }
           }
        } else {
           JOptionPane.showMessageDialog(this, "Non è stato possibile continuare col salvataggio", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //il bottone che mi serve per aggiungere elementi nella tabella di modifica
        String nome = jTextField1.getText().toUpperCase(); 
        String prezzoStr = jTextField2.getText();
        char errore=';';
        if(nome.contains(Character.toString(errore))){
                JOptionPane.showMessageDialog(this, "Carattere non valido (;)", "Errore", JOptionPane.ERROR_MESSAGE);
        }else{
            float prezzo = 0.0f; 
            if (nome.isEmpty() || prezzoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Inserisci il nome e il prezzo.", "Errore", JOptionPane.ERROR_MESSAGE); //Stampa messaggio di errore per le eccezzioni
                return;
            }
            try {
                prezzo = Float.parseFloat(prezzoStr); 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Prezzo non valido. Inserisci un numero valido.", "Errore", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            if (jRadioButton2.isSelected()) { //aggiungi alla tab4 se selezionato bar
                boolean senti=false;
                for (int i = 0; i < jTable4.getRowCount(); i++) {
                    if(nome.equalsIgnoreCase((String)jTable4.getValueAt(i, 0))){
                        senti=true;
                        JOptionPane.showMessageDialog(this, "Prodotto già inserito, modifica la tabella", "Errore", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if(senti==false){
                    DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
                    model.addRow(new Object[]{ nome, prezzo});
                    //contMod2++;
                }
            } else if (jRadioButton3.isSelected()) {  //aggiungi alla tab3 se selezionato ristorante
                boolean senti=false;
                for (int i = 0; i < jTable3.getRowCount(); i++) {
                    if(nome.equalsIgnoreCase((String)jTable3.getValueAt(i, 0))){
                        senti=true;
                        JOptionPane.showMessageDialog(this, "Prodotto già inserito, modifica la tabella", "Errore", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                if(senti==false){
                    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                    model.addRow(new Object[]{ nome, prezzo});
                    //contMod1++;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleziona se il prodotto è del bar o del ristorante.", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FileWriter f = null;
        PrintWriter fOUT = null;
        try{ //vado a salvare le mie due tabelle su csv, sempre con i soliti passaggi
            f = new FileWriter("tabella1.csv");
            fOUT = new PrintWriter(f);
        } catch (IOException e){
            System.exit(1);
        }
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            fOUT.println(jTable1.getValueAt(i, 1) + ";" + jTable1.getValueAt(i, 2));
        }
        fOUT.flush();
        try{
            f.close();
        }catch(IOException e){
            System.exit(1);
        }
        FileWriter f1 = null;
        PrintWriter fOUT1 = null;
        try{
            f1 = new FileWriter("tabella2.csv");
            fOUT1 = new PrintWriter(f1);
        } catch (IOException e){
            System.exit(1);
        }
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            fOUT1.println(jTable2.getValueAt(i, 1) + ";" + jTable2.getValueAt(i, 2));
        }
        fOUT1.flush();
        try{
            f1.close();
        }catch(IOException e){
            System.exit(1);
        }
        JOptionPane.showMessageDialog(this, "TABELLE SALVATE CORRETTAMENTE", "INFO", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
