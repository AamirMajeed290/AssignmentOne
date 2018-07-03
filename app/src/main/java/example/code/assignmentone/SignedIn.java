package example.code.assignmentone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignedIn extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @BindView(R.id.textViewUserName)
    TextView mTextViewUserName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);
        ButterKnife.bind(this);




        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        final String firstName= sharedPreferences.getString("firstName",null);
        final String lastName= sharedPreferences.getString("lastName",null);
        mTextViewUserName.setText("Hi " +firstName+" "+ lastName);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflator=getMenuInflater();
       inflator.inflate(R.menu.main_menu2,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {

            case R.id.innerAbout:
                Intent intentAbout=new Intent(this,About.class);
                startActivity(intentAbout);
                return true;
            case R.id.innerContact:
                Intent intentContact=new Intent(this,Contact.class);
                startActivity(intentContact);
                return true;
            case R.id.signOut:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
