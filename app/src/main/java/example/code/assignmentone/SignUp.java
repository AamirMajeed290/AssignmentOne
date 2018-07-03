package example.code.assignmentone;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;
import android.app.AlertDialog.Builder;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;
    public static final String USERS_DETAILS_KEY="userDetails";


    @BindView(R.id.textViewMessage)
    TextView mMessage;
    @BindView(R.id.editTextFirstName) EditText meditTextFirstName;
    @BindView(R.id.editTextLastName) EditText meditTextLastName;
    @BindView(R.id.editTextDOB) EditText meditTextDOB;
    @BindView(R.id.editTextPhoneNumber) EditText meditTextPhoneNumber;
    @BindView(R.id.editTextCurrencyType) EditText meditTextCurrencyType;
    @BindView(R.id.editTextCountryName) EditText meditCountryName;
    @BindView(R.id.editTextEmailAddress) EditText meditTextEmailAddress;
    @BindView(R.id.editTextPassword) EditText meditTextPassword;
    @BindView(R.id.buttonRegister) Button mButtonRegister;


    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);





        meditTextDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(SignUp.this,android.R.style.Theme_Holo_Light_Dialog,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                meditTextDOB.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                sharedPreferencesEditor=sharedPreferences.edit();
                sharedPreferencesEditor.putString("firstName", meditTextFirstName.getText().toString().substring(0, 1).toUpperCase() + meditTextFirstName.getText().toString().substring(1));
               sharedPreferencesEditor.putString("lastName", meditTextLastName.getText().toString().substring(0, 1).toUpperCase() + meditTextLastName.getText().toString().substring(1));
                sharedPreferencesEditor.putString("dOB",  meditTextDOB.getText().toString());
                sharedPreferencesEditor.putString("phoneNumber", meditTextPhoneNumber.getText().toString());
                sharedPreferencesEditor.putString("currencyType", meditTextCurrencyType.getText().toString());
                sharedPreferencesEditor.putString("countryName", meditCountryName.getText().toString());
                sharedPreferencesEditor.putString("emailAddress",meditTextEmailAddress.getText().toString());
                sharedPreferencesEditor.putString("password", meditTextPassword.getText().toString());

                sharedPreferencesEditor.commit();

               Intent intent = new Intent(getApplicationContext(), SignedIn.class);

               startActivity(intent);

            }
        });

    }


}
