package com.aninterface.interactive.tp5_dentistes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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

public class AdministrationActivity extends AppCompatActivity {

    AlertDialog.Builder bulder5;
    String moi;
    String insert0;
    String insert1;
    String[] tabline;
    private ListView listMenu3;
    private ArrayList<String> Menu3;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);

        final loginAdmin log = new loginAdmin(getApplicationContext());// initialisation de class loginAdmin extends Asynctac

        //arrayadapter popur afficher les patients deja enregistrer dans la base de données
        listMenu3 = findViewById(R.id.listMenu3);
        this.Menu3 = new ArrayList<String>();
         ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,this.Menu3);


        // dialogue a l'ouverture de l'activity pour loger l'administration
        LayoutInflater inflater = getLayoutInflater();
        View Layout = inflater.inflate(R.layout.loginadministrateur, null, false);
        final EditText login = (EditText) Layout.findViewById(R.id.login);
        final EditText password = (EditText) Layout.findViewById(R.id.password);

        //initialisation du dialogue
        bulder5 = new AlertDialog.Builder(this);
        bulder5.setTitle("Reservé à l'Administration");
        bulder5.setView(R.layout.loginadministrateur);
        bulder5.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // recuperation des valeur du dialogue utilisation de async tack  pour le login
                String userL = login.getText().toString();
                String userPw = password.getText().toString();

               log.execute(userL,userPw);//valeur du login demarrage de la class loginAdmin
            }
        });
        bulder5.create().show();

    }

    //asynctack pour le login
    private class loginAdmin extends AsyncTask
    {
        private Context c;
        private AlertDialog ad;
        public loginAdmin (Context c)
        {
            this.c = c;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String cible = "http://192.168.2.20/APP_Mob/TP5/login.php";
            try {
                URL url = new URL(cible);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setRequestMethod("POST");

                OutputStream outs = con.getOutputStream();
                BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(outs,"utf-8"));

                String msg = URLEncoder.encode("login","utf-8")+"="+
                        URLEncoder.encode((String)objects[0],"utf8")+"&"+
                        URLEncoder.encode("password","utf-8")+"="+
                        URLEncoder.encode((String)objects[1],"utf8");

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
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Object o) {
            //this.ad.setMessage((String)o);
            //this.ad.show();
            moi = ((String)o);
            String[] insert;
            insert = moi.split("/");
            insert0 = insert[0];
            insert1 = insert[1];
            //recuperation du login
            if(insert0.equals("true") )
            {
                //login correct lance l'asyntac pour afficher la liste des patient
                affichepatient aff = new affichepatient(getApplicationContext());
                aff.execute();
                Toast.makeText(getApplicationContext(),"Bievenu Docteur " + insert1,Toast.LENGTH_LONG).show();
            }
            else
            {
                this.ad.setMessage("Password ou Login Incorect ");
                this.ad.show();

            }
        }
    }

// Asyntac pour afficher la liste des patient enregistre dans la base de donnée
    private class affichepatient extends AsyncTask
    {
        private Context c;
        private AlertDialog ad;
        public affichepatient (Context c)
        {
            this.c = c;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String cible = "http://192.168.2.20/APP_Mob/TP5/.php";
            try {
                URL url = new URL(cible);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setDoInput(true);
                con.setDoOutput(true);
                con.setRequestMethod("POST");

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
            this.ad.setTitle("liste patients ");
        }

        @Override
        protected void onPostExecute(Object o) {
           String info = ((String)o);
            tabline = info.split("@");// tab a utiliser pour l'afficharge de la listview
            for (int i=0; i<=tabline.length-2; i++)
            {
                Menu3.add(tabline[i]);
            }
            listMenu3.setAdapter(adapter);
        }
    }
}
