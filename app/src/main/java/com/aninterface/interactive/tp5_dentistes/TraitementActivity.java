package com.aninterface.interactive.tp5_dentistes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class TraitementActivity extends AppCompatActivity {
    SharedPreferences save;     //declaration global du sharedpreferences

    String nom;
    String prenom;
    String datenais;
    String sexe;
    String nocivic;
    String rue;
    String app;
    String ville;
    String codePostal;
    String teltravail;
    String telmaison;
    String telportable;
    String couriel;
    String nas;
    String nam;
    String dateexp;
    String raisonvisite;
    String adressepar;
    String encasurgence;
    String telcasurgent;
    String tuteur;
    String monsieur;
    String nomparentcharge;
    String poids;
    String taille;
    String medecinfamille;
    String telmedecinfamille;
    String raisondessoins;
    String nomdumedecinQuiPrescrit;
    String telmedecinQuiPrescrit;
    String postemedecinQuiPrescrit;
    String raisondesmedicament;
    String nomdesmedicament;
    String nommedecinQuiPrescritMedicament;
    String telmedecinQuiPrescritMedicament;

    private ListView listMenu2;
    private ArrayList<String> Menu2;

    private final String MypreName = "sauvegarde";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traitement);

        save = getSharedPreferences(MypreName,getApplicationContext().MODE_PRIVATE);

        nom = save.getString("nom","aucun enregitrement");
        prenom = save.getString("prenom","aucun enregitrement");
        datenais = save.getString("datenais","aucun enregitrement");
        sexe = save.getString("sexe","aucun enregitrement");
        nocivic = save.getString("nocivic","aucun enregitrement");
        rue = save.getString("rue","aucun enregitrement");
        app = save.getString("app","aucun enregitrement");
        ville = save.getString("ville","aucun enregitrement");
        codePostal = save.getString("codePostal","aucun enregitrement");
        teltravail = save.getString("teltravail","aucun enregitrement");
        telmaison = save.getString("telmaison","aucun enregitrement");
        telportable = save.getString("telportable","aucun enregitrement");
        couriel = save.getString("couriel","aucun enregitrement");
        nas = save.getString("nas","aucun enregitrement");
        nam = save.getString("nam","aucun enregitrement");
        dateexp = save.getString("dateexp","aucun enregitrement");
        raisonvisite = save.getString("raisonvisite","aucun enregitrement");
        adressepar = save.getString("adressepar","aucun enregitrement");
        encasurgence = save.getString("encasurgence","aucun enregitrement");
        telcasurgent = save.getString("telcasurgent","aucun enregitrement");
        tuteur = save.getString("tuteur","aucun enregitrement");
        monsieur = save.getString("monsieur","aucun enregitrement");
        nomparentcharge = save.getString("nomparentcharge","aucun enregitrement");
        poids = save.getString("poids","aucun enregitrement");
        taille = save.getString("taille","aucun enregitrement");
        medecinfamille = save.getString("medecinfamille","aucun enregitrement");
        telmedecinfamille = save.getString("telmedecinfamille","aucun enregitrement");
        raisondessoins = save.getString("raisondessoins","aucun enregitrement");
        nomdumedecinQuiPrescrit = save.getString("nomdumedecinQuiPrescrit","aucun enregitrement");
        telmedecinQuiPrescrit = save.getString("telmedecinQuiPrescrit","aucun enregitrement");
        postemedecinQuiPrescrit = save.getString("postemedecinQuiPrescrit","aucun enregitrement");
        raisondesmedicament = save.getString("raisondesmedicament","aucun enregitrement");
        nomdesmedicament = save.getString("nomdesmedicament","aucun enregitrement");
        nommedecinQuiPrescritMedicament = save.getString("nommedecinQuiPrescritMedicament","aucun enregitrement");
        telmedecinQuiPrescritMedicament = save.getString("telmedecinQuiPrescritMedicament","aucun enregitrement");


        listMenu2 = findViewById(R.id.listMenu2);
        this.Menu2 = new ArrayList<String>();

        this.Menu2.add("Nom: " + nom );
        this.Menu2.add("Prenom: " + prenom );
        this.Menu2.add("Date de naissance: " + datenais );
        this.Menu2.add("Sexe: " + sexe );
        this.Menu2.add("Numero civic: " + nocivic);
        this.Menu2.add("Rue: " + rue);
        this.Menu2.add("Appartement: " + app );
        this.Menu2.add("Ville: " + ville );
        this.Menu2.add("Code postal: " + codePostal );
        this.Menu2.add("Telephone du travail: " + teltravail);
        this.Menu2.add("Telephone à domicile: " + telmaison );
        this.Menu2.add("Cellulaire: " + telportable );
        this.Menu2.add("Couriel: " + couriel );
        this.Menu2.add("NAS: " + nas );
        this.Menu2.add("Numero A M: " + nam );
        this.Menu2.add("Date exp carte A M: " + dateexp );
        this.Menu2.add("Raison de la visite: " + raisonvisite);
        this.Menu2.add("Adressé par: " + adressepar);
        this.Menu2.add("contacter en cas d'urgence: " + encasurgence);
        this.Menu2.add("Telephone en cas d'urgence: " + telcasurgent);
        this.Menu2.add("Personne en charge: " + tuteur);
        this.Menu2.add( monsieur);
        this.Menu2.add("Nom parent en charge: " + nomparentcharge);
        this.Menu2.add("Poids: " + poids);
        this.Menu2.add("taille: " + taille);
        this.Menu2.add("Nom medecin familliale: " + medecinfamille);
        this.Menu2.add("Telephone médecin familliale: " + telmedecinfamille);
        this.Menu2.add("Raison des soins " + raisondessoins);
        this.Menu2.add("Nom du médecin pour les soins: " + nomdumedecinQuiPrescrit);
        this.Menu2.add("Telephone du médecin pour les soins: " + telmedecinQuiPrescrit);
        this.Menu2.add("Poste du médecin pour les soins: " + postemedecinQuiPrescrit);
        this.Menu2.add("Raison des médicament: " + raisondesmedicament);
        this.Menu2.add("Nom du médicament: " + nomdesmedicament);
        this.Menu2.add("Nom du medecin pour médicament: " + nommedecinQuiPrescritMedicament);
        this.Menu2.add("Telephone du medecin pour médicament: " + telmedecinQuiPrescritMedicament);

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,this.Menu2);
        this.listMenu2.setAdapter(adapter);
    }
    private class soumissionInfo extends AsyncTask
    {
        private Context c;
        private AlertDialog ad;
        public soumissionInfo (Context c)
        {
            this.c = c;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String cible = "http://192.168.1.105/APP_Mob/TP5/insert.php";
            try {
                URL url = new URL(cible);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setRequestMethod("POST");

                OutputStream outs = con.getOutputStream();
                BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(outs,"utf-8"));

                String msg = URLEncoder.encode("var1","utf-8")+"="+
                        URLEncoder.encode((String)objects[0],"utf8")+"&"+
                        URLEncoder.encode("var2","utf-8")+"="+
                        URLEncoder.encode((String)objects[1],"utf8")+"&"+
                        URLEncoder.encode("var3","utf-8")+"="+
                        URLEncoder.encode((String)objects[2],"utf8")+"&"+
                        URLEncoder.encode("var4","utf-8")+"="+
                        URLEncoder.encode((String)objects[3],"utf8")+"&"+
                        URLEncoder.encode("var5","utf-8")+"="+
                        URLEncoder.encode((String)objects[4],"utf8")+"&"+
                        URLEncoder.encode("var6","utf-8")+"="+
                        URLEncoder.encode((String)objects[5],"utf8")+"&"+
                        URLEncoder.encode("var7","utf-8")+"="+
                        URLEncoder.encode((String)objects[6],"utf8")+"&"+
                        URLEncoder.encode("var8","utf-8")+"="+
                        URLEncoder.encode((String)objects[7],"utf8")+"&"+
                        URLEncoder.encode("var9","utf-8")+"="+
                        URLEncoder.encode((String)objects[8],"utf8")+"&"+
                        URLEncoder.encode("var10","utf-8")+"="+
                        URLEncoder.encode((String)objects[9],"utf8")+"&"+
                        URLEncoder.encode("var11","utf-8")+"="+
                        URLEncoder.encode((String)objects[10],"utf8")+"&"+
                        URLEncoder.encode("var12","utf-8")+"="+
                        URLEncoder.encode((String)objects[11],"utf8")+"&"+
                        URLEncoder.encode("var13","utf-8")+"="+
                        URLEncoder.encode((String)objects[12],"utf8")+"&"+
                        URLEncoder.encode("var14","utf-8")+"="+
                        URLEncoder.encode((String)objects[13],"utf8")+"&"+
                        URLEncoder.encode("var15","utf-8")+"="+
                        URLEncoder.encode((String)objects[14],"utf8")+"&"+
                        URLEncoder.encode("var16","utf-8")+"="+
                        URLEncoder.encode((String)objects[15],"utf8")+"&"+
                        URLEncoder.encode("var17","utf-8")+"="+
                        URLEncoder.encode((String)objects[16],"utf8")+"&"+
                        URLEncoder.encode("var18","utf-8")+"="+
                        URLEncoder.encode((String)objects[17],"utf8")+"&"+
                        URLEncoder.encode("var19","utf-8")+"="+
                        URLEncoder.encode((String)objects[18],"utf8")+"&"+
                        URLEncoder.encode("var20","utf-8")+"="+
                        URLEncoder.encode((String)objects[19],"utf8")+"&"+
                        URLEncoder.encode("var21","utf-8")+"="+
                        URLEncoder.encode((String)objects[20],"utf8")+"&"+
                        URLEncoder.encode("var22","utf-8")+"="+
                        URLEncoder.encode((String)objects[21],"utf8")+"&"+
                        URLEncoder.encode("var23","utf-8")+"="+
                        URLEncoder.encode((String)objects[22],"utf8")+"&"+
                        URLEncoder.encode("var24","utf-8")+"="+
                        URLEncoder.encode((String)objects[23],"utf8")+"&"+
                        URLEncoder.encode("var25","utf-8")+"="+
                        URLEncoder.encode((String)objects[24],"utf8")+"&"+
                        URLEncoder.encode("var26","utf-8")+"="+
                        URLEncoder.encode((String)objects[25],"utf8")+"&"+
                        URLEncoder.encode("var27","utf-8")+"="+
                        URLEncoder.encode((String)objects[26],"utf8")+"&"+
                        URLEncoder.encode("var28","utf-8")+"="+
                        URLEncoder.encode((String)objects[27],"utf8")+"&"+
                        URLEncoder.encode("var29","utf-8")+"="+
                        URLEncoder.encode((String)objects[28],"utf8")+"&"+
                        URLEncoder.encode("var30","utf-8")+"="+
                        URLEncoder.encode((String)objects[29],"utf8")+"&"+
                        URLEncoder.encode("var31","utf-8")+"="+
                        URLEncoder.encode((String)objects[30],"utf8")+"&"+
                        URLEncoder.encode("var32","utf-8")+"="+
                        URLEncoder.encode((String)objects[31],"utf8")+"&"+
                        URLEncoder.encode("var33","utf-8")+"="+
                        URLEncoder.encode((String)objects[32],"utf8")+"&"+
                        URLEncoder.encode("var34","utf-8")+"="+
                        URLEncoder.encode((String)objects[33],"utf8")+"&"+
                        URLEncoder.encode("var35","utf-8")+"="+
                        URLEncoder.encode((String)objects[34],"utf8")+"&"+
                        URLEncoder.encode("var36","utf-8")+"="+
                        URLEncoder.encode((String)objects[35],"utf8");


                bufw.write(msg);
                bufw.flush();
                bufw.close();
                outs.close();

                InputStream ins = con.getInputStream();
                BufferedReader bufr = new BufferedReader(new InputStreamReader(ins,"iso-8859-1"));
                String line;
                StringBuffer sbuff = new StringBuffer();

                while ((line = bufr.readLine()) !=null)
                {
                    sbuff.append(line + "\n");
                }
                return  sbuff.toString();
            }
            catch (Exception ex)
            {
                return ex.getMessage();
            }
        }
        @Override
        protected void onPreExecute() {
            this.ad = new AlertDialog.Builder(this.c).create();
            this.ad.setTitle("Statut de l'inscription ");
        }
        @Override
        protected void onPostExecute(Object o) {
            this.ad.setMessage("Inscription reussi, Veuillez attendre qu'on vous appelle  ");
            this.ad.show();
        }
    }
    public void validation(View view)
    {
        soumissionInfo soumInfo = new soumissionInfo(this);
        soumInfo.execute( nom,prenom,datenais,sexe,nocivic,rue,app,ville,codePostal,teltravail,telmaison,
                        telportable,couriel,nas,nam,dateexp,raisonvisite,adressepar,encasurgence,telcasurgent,
                        tuteur,monsieur,nomparentcharge,poids,taille,medecinfamille,telmedecinfamille,raisondessoins,
                        nomdumedecinQuiPrescrit,telmedecinQuiPrescrit,postemedecinQuiPrescrit,raisondesmedicament,
                        nomdesmedicament,nommedecinQuiPrescritMedicament,telmedecinQuiPrescritMedicament);
    }
}
