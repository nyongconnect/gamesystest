package com.example.gamesystest.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.gamesystest.R
import com.example.gamesystest.databinding.ActivityMainBinding
import com.example.gamesystest.presentation.extensions.makeGone
import com.example.gamesystest.presentation.extensions.makeVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        navController  = findNavController(R.id.nav_host_fragment)

        setSupportActionBar(binding.toolbar)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.countryDetailsFragment)
        )

        navController.addOnDestinationChangedListener {_, destination, _ ->
            when(destination.id) {
                R.id.homeFragment -> binding.toolbar.makeVisible()
                R.id.countryDetailsFragment -> binding.toolbar.makeGone()
            }
        }
        setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}