package example.code.assignmentone;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private RadioButton getmRadioButtonRememberMe;
    private Button mButtonSignIn;
    private TextView mTextViewCreateAccount;
    private RadioButton mRadioButtonRememberMe;
    private EditText mEditTextUserId;
    private EditText mEditTextPassword;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferenceEditor;
    private String prefUserId="USER_ID";
    private String prefUserPassword=" USER_PASSWORD";

    private Intent mIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonSignIn = findViewById(R.id.buttonSignIn);
        mTextViewCreateAccount=findViewById(R.id.textViewCreateAccount);
        mRadioButtonRememberMe = findViewById(R.id.radioButtonRememberMe);
        mEditTextUserId = findViewById(R.id.editTextUserId);
        mEditTextPassword = findViewById(R.id.editTextPassword);



        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        final String mUserId = mSharedPreferences.getString(prefUserId,null);
        final String mUserPassword = mSharedPreferences.getString(prefUserPassword, null);

        if (mUserId != null || mUserPassword != null) {
            mEditTextUserId.setText(mUserId);
            mEditTextPassword.setText(mUserPassword);


        }
        

        final String emailAddress= mSharedPreferences.getString("emailAddress",null);
        final String password= mSharedPreferences.getString("password",null);


        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mEditTextUserId.getText().toString().equals(emailAddress) && mEditTextPassword.getText().toString().equals(password)) {

                    mSharedPreferenceEditor=mSharedPreferences.edit();
                if (mRadioButtonRememberMe.isChecked()) {




                    mSharedPreferenceEditor.putString(prefUserId, mEditTextUserId.getText().toString());
                    mSharedPreferenceEditor .putString(prefUserPassword, mEditTextPassword.getText().toString());





                }
                else
                {
                    mSharedPreferenceEditor.putString(prefUserId, "");
                    mSharedPreferenceEditor .putString(prefUserPassword, "");


                }
                    mSharedPreferenceEditor.commit();

                    mIntent = new Intent(getApplicationContext(), SignedIn.class);
                    startActivity(mIntent);
                }


            }
        });


        mTextViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(mIntent);



            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.main_menu,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {

            case R.id.about:
                Intent intentAbout=new Intent(this,About.class);
                startActivity(intentAbout);
                return true;
            case R.id.contact:
                Intent intentContact=new Intent(this,Contact.class);
                startActivity(intentContact);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    }


