package com.aninterface.interactive.tp5_dentistes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView listMenu;
    private ArrayList<String>Menu;
    AlertDialog.Builder bulder0;
    AlertDialog.Builder bulder01;
    AlertDialog.Builder bulder1;
    AlertDialog.Builder bulder2;
    AlertDialog.Builder bulder21;
    AlertDialog.Builder bulder3;
    AlertDialog.Builder bulder31;
    AlertDialog.Builder bulder4;
    AlertDialog.Builder bulder41;
    AlertDialog.Builder bulder42;
    AlertDialog.Builder bulder43;
    AlertDialog.Builder bulder5;
    private final String MypreName = "sauvegarde";
    SharedPreferences save;
    //Intent a;
    Intent b;

    String sexechoix;
    String tuteur;
    String monsieur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater0 = getLayoutInflater();
        View Layout0 = inflater0.inflate(R.layout.layoutinfopersonnel1, null, false);
        final EditText nom = (EditText) Layout0.findViewById(R.id.editText00);
        final EditText prenom = (EditText) Layout0.findViewById(R.id.editText01);
        final EditText datenais = (EditText) Layout0.findViewById(R.id.editText02);

        LayoutInflater inflater1 = getLayoutInflater();
        View Layout1 = inflater1.inflate(R.layout.layoutinfopersonnel3, null, false);
        final EditText nocivic = (EditText) Layout1.findViewById(R.id.editText10);
        final EditText rue = (EditText) Layout1.findViewById(R.id.editText11);
        final EditText app = (EditText) Layout1.findViewById(R.id.editText12);
        final EditText ville = (EditText) Layout1.findViewById(R.id.editText13);
        final EditText codepostal = (EditText) Layout1.findViewById(R.id.editText14);

        LayoutInflater inflater2 = getLayoutInflater();
        View Layout2 = inflater2.inflate(R.layout.contact, null, false);
        final EditText teltravail = (EditText) Layout2.findViewById(R.id.editText20);
        final EditText telmaison = (EditText) Layout2.findViewById(R.id.editText21);
        final EditText telportable = (EditText) Layout2.findViewById(R.id.editText22);
        final EditText couriel = (EditText) Layout2.findViewById(R.id.editText23);

        LayoutInflater inflater21 = getLayoutInflater();
        View Layout21 = inflater21.inflate(R.layout.autreinfo, null, false);
        final EditText nas = (EditText) Layout21.findViewById(R.id.editText2_00);
        final EditText nam = (EditText) Layout21.findViewById(R.id.editText2_01);
        final EditText dateexp = (EditText) Layout21.findViewById(R.id.editText2_02);

        LayoutInflater inflater3 = getLayoutInflater();
        View Layout3 = inflater3.inflate(R.layout.raisonvisite, null, false);
        final EditText raisonvisite = (EditText) Layout3.findViewById(R.id.editText30);
        final EditText adressepar = (EditText) Layout3.findViewById(R.id.editText31);
        final EditText encasurgence = (EditText) Layout3.findViewById(R.id.editText32);
        final EditText telcasurgent = (EditText) Layout3.findViewById(R.id.editText33);

        LayoutInflater inflater31 = getLayoutInflater();
        View Layout31 = inflater31.inflate(R.layout.personnecharge, null, false);
        final EditText nomparentcharge = (EditText) Layout31.findViewById(R.id.editText3_00);

        LayoutInflater inflater4 = getLayoutInflater();
        View Layout4 = inflater4.inflate(R.layout.antecedentmedicaux, null, false);
        final EditText poids = (EditText) Layout4.findViewById(R.id.editText40);
        final EditText taille = (EditText) Layout4.findViewById(R.id.editText41);
        final EditText medecinfamille = (EditText) Layout4.findViewById(R.id.editText42);
        final EditText telmedecinfamille = (EditText) Layout4.findViewById(R.id.editText43);

        LayoutInflater inflater41 = getLayoutInflater();
        View Layout41 = inflater41.inflate(R.layout.antecedentmedicaux1, null, false);
        final EditText raisondessoins = (EditText) Layout41.findViewById(R.id.editText4_00);
        final EditText nomdumedecinQuiPrescritSoins = (EditText) Layout41.findViewById(R.id.editText4_01);
        final EditText telmedecinQuiPrescritSoins = (EditText) Layout41.findViewById(R.id.editText4_02);
        final EditText postemedecinQuiPrescritSoins = (EditText) Layout41.findViewById(R.id.editText4_03);

        LayoutInflater inflater43 = getLayoutInflater();
        View Layout43 = inflater43.inflate(R.layout.antecedentmedicaux3, null, false);
        final EditText raisondesmedicament = (EditText) Layout43.findViewById(R.id.editText4_30);
        final EditText nomdesmedicament = (EditText) Layout43.findViewById(R.id.editText4_31);
        final EditText nommedecinQuiPrescritMedicament = (EditText) Layout43.findViewById(R.id.editText4_32);
        final EditText telmedecinQuiPrescritMedicament = (EditText) Layout43.findViewById(R.id.editText4_33);

        b = new Intent(this, TraitementActivity.class);
        //a = new Intent(this, AdministrationActivity.class);

        save = getSharedPreferences(MypreName,getApplicationContext().MODE_PRIVATE);
        final SharedPreferences.Editor edit = save.edit();

        //constitution des elements de l'arraylist qui seront afficher dans le listview
        listMenu = findViewById(R.id.listMenu);
        this.Menu = new ArrayList<String>();
        this.Menu.add("Informations personelles ");
        this.Menu.add("Localisation");
        this.Menu.add("Contacts");
        this.Menu.add("Raison de la visite");
        this.Menu.add("Antécédents médicaux");


        //declaration des dialogues
        final AlertDialog.Builder bulder0 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder01 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder1 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder2 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder21 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder3 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder31 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder4 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder41 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder42 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder43 = new AlertDialog.Builder(this);
        final AlertDialog.Builder bulder5 = new AlertDialog.Builder(this);

        //declaration des adapters pour l'afficharge des listview
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,this.Menu);
        this.listMenu.setAdapter(adapter);

        //declaration d'un evenement suite au click d'un item sur la listeview
        this.listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //item cliquer a la position 0 - info personnel
                if (position==0)
                {
                    // appel du premier dialogue
                    bulder0.setTitle("Informations personnelles");
                    bulder0.setView(R.layout.layoutinfopersonnel1);
                    bulder0.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //edit.clear();

                            //enregistrement des saisi fait dans le dialogue info personnel
                                String voirnom = nom.getText().toString();
                            //edit.putString("name",nom.getText().toString());
                            edit.putString("name","ngassa");
                            edit.putString("prename","magloire");
                            //edit.putString("prename",prenom.getText().toString());
                            edit.putString("datenais",datenais.getText().toString());
                            edit.apply();

                            // appel du dialogue sexe
                            bulder01.setTitle("SEXE");//pas encore fini
                            final String[] sexe = {"Feminin","Masculin"};
                            bulder01.setView(R.layout.layoutinfopersonnel2);
                            bulder01.setSingleChoiceItems(sexe, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    //choix du sexe
                                    if(which==1)
                                    {
                                        sexechoix = "Feminin";
                                    }
                                    else {
                                        sexechoix = "Masculin";
                                    }
                                }
                            });
                            bulder01.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    // enregistrement des donnés saisi dans le dialogue sexe et retour a la page d'accueil
                                    edit.putString("sexe",sexechoix);
                                    edit.apply();
                                }
                            });
                            bulder01.create().show();
                        }
                    });
                    bulder0.create().show();
                }

                //item cliquer a la position 1 - localisation
                if (position==1)
                {
                    bulder1.setTitle("Localisation");
                    bulder1.setView(R.layout.layoutinfopersonnel3);
                    bulder1.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //enregistrement des données saisi dans le dialogue localisation retour a la page d'acceuil
                            edit.putString("nocivic",nocivic.getText().toString());
                            edit.putString("rue",rue.getText().toString());
                            edit.putString("app",app.getText().toString());
                            edit.putString("ville",ville.getText().toString());
                            edit.putString("codepostal",codepostal.getText().toString());
                            edit.apply();
                        }
                    });
                    bulder1.create().show();
                    //Toast.makeText(MainActivity.this,"info personnelle1",Toast.LENGTH_LONG).show();
                }

                //item cliquer a la position 2 - contact
                if (position==2)
                {
                    bulder2.setTitle("Contact");
                    bulder2.setView(R.layout.contact);
                    bulder2.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //enregistrement des données saisi dans le dialogue contact
                            edit.putString("teltravail",teltravail.getText().toString());
                            edit.putString("telmaison",telmaison.getText().toString());
                            edit.putString("telportable",telportable.getText().toString());
                            edit.putString("couriel",couriel.getText().toString());
                            edit.apply();

                            //  declenchement du dialogue autre info
                            bulder21.setTitle("Information supplementaire");
                            bulder21.setView(R.layout.autreinfo);
                            bulder21.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //enregistrement des données saisi dans le dialogue autreinfo et retour a la page d'acceuil
                                    edit.putString("nas",nas.getText().toString());
                                    edit.putString("nam",nam.getText().toString());
                                    edit.putString("dateexp",dateexp.getText().toString());
                                    edit.apply();
                                }
                            });
                            bulder21.create().show();
                        }
                    });
                    bulder2.create().show();

                    //Toast.makeText(MainActivity.this,"info personnelle2",Toast.LENGTH_LONG).show();
                }
                //item cliquer a la position 3 - raison de la visite
                if (position==3)
                {
                    bulder3.setTitle("Raison de la visite");
                    bulder3.setView(R.layout.raisonvisite);
                    bulder3.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //clique sur oui j'ai moins de 18 ans
                            //enregistrement des données saisi dans le dialogue raison visite
                            edit.putString("raisonvisite",raisonvisite.getText().toString());
                            edit.putString("adressepar",adressepar.getText().toString());
                            edit.putString("encasurgence",encasurgence.getText().toString());
                            edit.putString("telcasurgent",telcasurgent.getText().toString());
                            edit.apply();

                            // et appel du dialogue personne en charge
                            bulder31.setTitle("Personne en charge");
                            bulder31.setView(R.layout.personnecharge);
                            final String[] personne = {"Parent","Tuteur","Monsieur","Madame"};
                            bulder31.setMultiChoiceItems(personne, null, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    //recuperation des choix du parent
                                    if(which==0 && isChecked==true)
                                    {
                                        tuteur = personne[which];
                                    }
                                    if(which==1 && isChecked==true)
                                    {
                                        tuteur = personne[which];
                                    }
                                    if(which==2 && isChecked==true)
                                    {
                                        monsieur = personne[which];
                                    }
                                    if(which==3 && isChecked==true)
                                    {
                                        monsieur = personne[which];
                                    }
                                }
                            });
                            bulder31.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //enregitrement des choix et du nom du parent en charge
                                    edit.putString("tuteur",tuteur.toString());
                                    edit.putString("monsieur",monsieur.toString());
                                    edit.putString("nomparentcharge",nomparentcharge.getText().toString());
                                    edit.apply();
                                }
                            });
                            bulder31.create().show();
                        }
                    });
                    bulder3.setNegativeButton("non", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //clique sur non j'ai pas moins de 18 ans
                            //enregistrement des données saisi dans le dialogue raison visite et retour a la page d'acceuil
                            edit.putString("raisonvisite",raisonvisite.getText().toString());
                            edit.putString("adressepar",adressepar.getText().toString());
                            edit.putString("encasurgence",encasurgence.getText().toString());
                            edit.putString("telcasurgent",telcasurgent.getText().toString());
                            edit.apply();
                        }
                    });
                    bulder3.create().show();
                    //Toast.makeText(MainActivity.this,"info personnelle3",Toast.LENGTH_LONG).show();
                }
                // item cliquer a la position 4 - antécédent médicaux
                if(position==4)
                {
                    bulder4.setTitle("Antécédents médicaux");
                    bulder4.setView(R.layout.antecedentmedicaux);
                    bulder4.setPositiveButton("non", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edit.putString("poids",poids.getText().toString());
                            edit.putString("taille",taille.getText().toString());
                            edit.putString("medecinfamille",medecinfamille.getText().toString());
                            edit.putString("telmedecinfamille",telmedecinfamille.getText().toString());
                            edit.apply();
                        }
                    });
                    bulder4.setNegativeButton("oui", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edit.putString("poids",poids.getText().toString());
                            edit.putString("taille",taille.getText().toString());
                            edit.putString("medecinfamille",medecinfamille.getText().toString());
                            edit.putString("telmedecinfamille",telmedecinfamille.getText().toString());
                            edit.apply();

                            bulder41.setTitle("Antécédents médicaux");
                            bulder41.setView(R.layout.antecedentmedicaux1);
                            bulder41.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    edit.putString("raisondessoins",raisondessoins.getText().toString());
                                    edit.putString("nomdumedecinQuiPrescrit",nomdumedecinQuiPrescritSoins.getText().toString());
                                    edit.putString("telmedecinQuiPrescrit",telmedecinQuiPrescritSoins.getText().toString());
                                    edit.putString("postemedecinQuiPrescrit",postemedecinQuiPrescritSoins.getText().toString());
                                    edit.apply();

                                    // enregistrement des donnee saisi dans le dialogue antecedent medical1 et appel de antecedent medical2
                                    bulder42.setTitle("Antécédents médicaux");
                                    bulder42.setView(R.layout.antecedentmedicaux2);
                                    bulder42.setPositiveButton("oui", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {


                                            //lancement du dialogue pour recuper les medicament utilisé
                                            bulder43.setTitle("Antécédents médicaux");
                                            bulder43.setView(R.layout.antecedentmedicaux3);
                                            bulder43.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    edit.putString("raisondesmedicament",raisondesmedicament.getText().toString());
                                                    edit.putString("nomdesmedicament",nomdesmedicament.getText().toString());
                                                    edit.putString("nommedecinQuiPrescritMedicament",nommedecinQuiPrescritMedicament.getText().toString());
                                                    edit.putString("telmedecinQuiPrescritMedicament",telmedecinQuiPrescritMedicament.getText().toString());
                                                    edit.apply();

                                                    //triatement et affiche dans un listView l'ensemble des information reçu
                                                    //redirection vers l'activité traitement pour le traitement et l'afficharge des données


                                                }
                                            });
                                            bulder43.create().show();
                                        }
                                    });
                                    bulder42.setNegativeButton("non", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // triatement et affiche dans un listView l'ensemble des information reçu
                                            //redirection vers l'activité traitement pour le traitement et l'afficharge des données

                                        }
                                    });
                                    bulder42.create().show();
                                }
                            });
                            bulder41.create().show();
                        }
                    });

                    bulder4.create().show();
                }
            }
        });
    }
    // creation du menu
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuItem mi1 = menu.add(01,01,0,"ADMINISTRATION");
        return true;
    }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        Intent i;
        switch (item.getItemId())
        {
            case 01:
               i=new Intent(this,AdministrationActivity.class);
                startActivity(i);
                return true;
        }
        return true;
    }
    public void soumission(View view)
    {
        //activity a --traitementActivity
        startActivity(b);
    }
}

