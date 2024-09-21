package com.example.loginapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

FirebaseFirestore firestore;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super .onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    firestore = FirebaseFirestore.getInstance);
    Map<String, Object> user = new HashMap<>);
    user.put( k "firstName", v: "Easy"); user.put (k "lastName", v: "Tuto"); user.put ( k "decription", v: "Subscribe");
    firestore.collection ( collectionPath: "users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentRefere
    @Override
    public void onSuccess(DocumentReference documentReference) {
        Toast.makeText(getApplicationContext(), text: "Success", Toast.LENGTH_LONG) . show);
    }
}) .addOnFailureListener(new OnFailureListener@) {
    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(getApplicationContext(), text: "Failure", Toast.LENGTH_LONG) .show();
    }
});


class MainActivity : AppCompatActivity() {


    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.username_input)

        passwordInput = findViewById(R.id.password_input)

        loginBtn = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            Log.i("Test Credintials", "Username : $username and Password : $password")
        }


        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets*/

        }
    }
