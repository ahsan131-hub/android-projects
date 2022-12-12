package com.example.intentspractice

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.jar.Manifest

class Home : AppCompatActivity() {
//    val RESULT_OK=555;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<TextView>(R.id.textView).text=this.intent.getStringExtra("name")

    }

    fun goBack(view: View){
        val intent=Intent()
        intent.putExtra("name",findViewById<EditText>(R.id.username).text.toString())
        setResult(RESULT_OK,intent)
        finish()
    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun goToUrl(view: View){
        var url: Uri =Uri.parse("https://www.fiverr.com/users/ahsanjsdev/manage_gigs")
        val webIntent:Intent=Intent(Intent.ACTION_VIEW,url)
        startActivity(webIntent)


    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun captureImge(view:View){

        if(checkSelfPermission(android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,1223)
        }else{
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA),1223)

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1223&& resultCode== RESULT_OK){
            Toast.makeText(this,data?.getStringExtra("name").toString(),Toast.LENGTH_SHORT).show();

            val imageView=findViewById<ImageView>(R.id.imageView)
            val bmp=data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(bmp)

        }
    }


    fun goToAdaptors(view: View){
        var adpatorIntent:Intent=Intent(this,Adaptors::class.java)
        startActivity(adpatorIntent)
    }
    fun goToSqlite(view: View){
        var adpatorIntent:Intent=Intent(this,Sqllite::class.java)
        startActivity(adpatorIntent)
    }
    fun gotoFiling(view: View){
        startActivity(Intent(this,Filing::class.java))


    }
    fun goToMedia(view: View){
        startActivity(Intent(this,PlayMedia::class.java))
    }
    fun goToBackgroundService(view: View){
            startActivity(Intent(this,BackgroundService::class.java))

    }

}