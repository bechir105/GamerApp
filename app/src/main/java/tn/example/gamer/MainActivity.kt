package tn.example.gamer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import tn.example.gamer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar.appBar
        setSupportActionBar(toolbar)

        binding.btnNews.setOnClickListener {
            changeFragment(NewsFragment(), "News")
        }

        binding.btnEvents.setOnClickListener {
            changeFragment(StoreFragment(), "Store")
        }

        binding.btnProfile.setOnClickListener {
            changeFragment(ProfileFragment(), "Profile")
        }

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, NewsFragment()).commit()
    }

    private fun changeFragment(fragment: Fragment, name: String) {

        if (name.isEmpty())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        else
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("").commit()

        supportActionBar?.title = title

    }





}