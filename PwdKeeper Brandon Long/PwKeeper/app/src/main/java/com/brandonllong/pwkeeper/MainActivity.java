package com.brandonllong.pwkeeper;

/**
 *
 * /\\\\\\\\\\\\    /\\\              /\\\\\\\\\\\    /\\\\\     /\\\    /\\\\\\\\\\\
 * \/\\\////////\\\ \/\\\            /\\\\////////\\\ \/\\\\\\   \/\\\  /\\\\////////\\\
 *  \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\/\\\  \/\\\ \/\\\       \///
 *   \/\\\\\\\\\\\\/  \/\\\           \/\\\       \/\\\ \/\\\//\\\ \/\\\ \/\\\
 *    \/\\\///////\\\\ \/\\\           \/\\\       \/\\\ \/\\\\//\\\\/\\\ \/\\\     /\\\\\\
 *     \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\ \//\\\/\\\ \/\\\    \////\\\
 *      \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\  \//\\\\\\ \/\\\       \/\\\
 *       \/\\\\\\\\\\\\/  \/\\\\\\\\\\\\\ \/\/\\\\\\\\\\\/  \/\\\   \//\\\\\ \/\/\\\\\\\\\\\/
 *        \////////////    \/////////////    \///////////    \///     \/////    \///////////
 *
 * Created by brandonlong on 4/29/16.
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    EditText idView,descriptionBox,passwordBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idView = (EditText) findViewById(R.id.idText);
        descriptionBox = (EditText) findViewById(R.id.descriptionText);
        passwordBox = (EditText) findViewById(R.id.passwordText);
    }
    public void addPassword (View view) {

        DbHandler dbHandler = new DbHandler(this, null, null, 1);

        Wallet wallet =

                new Wallet();

        wallet.setPassword(passwordBox.getText().toString());
        wallet.setDescription(descriptionBox.getText().toString());
        dbHandler.addPassword(wallet);
        descriptionBox.setText("");
        passwordBox.setText("");

    }

    public void findPassword (View view) {
        DbHandler dbHandler = new DbHandler(this, null, null, 1);
        Wallet wallet = dbHandler.findPassword(descriptionBox.getText().toString());

        if (wallet != null) {
            idView.setText(String.valueOf(wallet.getId()));
            passwordBox.setText(String.valueOf(wallet.getPassword()));

        } else {
            idView.setText("No Match Found");

        }

    }

    public void deletePassword(View view) {

        DbHandler dbHandler = new DbHandler(this, null, null, 1);

        boolean result = dbHandler.deletePassword(descriptionBox.getText().toString());

        if (result) {
            idView.setText("Record Deleted");
            descriptionBox.setText("");
            passwordBox.setText("");
        }

        else
            idView.setText("No Match Found");

    }
}
