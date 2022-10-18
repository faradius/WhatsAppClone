package com.alex.whatsappclone.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alex.whatsappclone.R
import com.hbb20.CountryCodePicker

class MainActivity : AppCompatActivity() {

    var btnSendCode: Button? = null
    var etPhone: EditText? = null
    var countryCodePicker: CountryCodePicker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSendCode = findViewById(R.id.btnSendCode)
        etPhone = findViewById(R.id.etPhone)
        countryCodePicker = findViewById(R.id.ccp)

        btnSendCode?.setOnClickListener(View.OnClickListener { //                goToCodeVerificationActivity();
            getData()
        })
    }

    private fun getData() {
        val code = countryCodePicker!!.selectedCountryCodeWithPlus
        val phone = etPhone!!.text.toString()
        if (phone == "") {
            Toast.makeText(this, "Debe insertar el telefono", Toast.LENGTH_SHORT).show()
        } else {
            goToCodeVerificationActivity(code + phone)
            //            Toast.makeText(this, "Telefono: "+ code + " " + phone, Toast.LENGTH_LONG).show();
        }
    }

    private fun goToCodeVerificationActivity(phone: String) {
        val i = Intent(this@MainActivity, CodeVerificationActivity::class.java)
        i.putExtra("phone", phone)
        startActivity(i)
    }
}