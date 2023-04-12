package com.bleepingdragon.compass

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.bleepingdragon.compass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Other
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    //Views
    private lateinit var bottomNavigationBarView: BottomNavigationView


    //When creating the screen
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        //Initialize variables
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Find the views
        bottomNavigationBarView = findViewById(R.id.bottomNavigationView)

        //Find the fragment
        //https://stackoverflow.com/questions/50502269/illegalstateexception-link-does-not-have-a-navcontroller-set
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (navHostFragment != null) {
            navController = navHostFragment.findNavController()
        }

        //Setup the bottom bar so it displays different fragments
        bottomNavigationBarView.setupWithNavController(navController)

        //Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(R.id.compassFragment, R.id.settingsFragment))

        //Hide navbar in some fragments
        navController.addOnDestinationChangedListener { _, destination, _ ->

            if(destination.id == R.id.aboutFragment) {
                //bottomNavigationBarView.visibility = View.GONE
            } else {
                //bottomNavigationBarView.visibility = View.VISIBLE
            }
        }
    }
}