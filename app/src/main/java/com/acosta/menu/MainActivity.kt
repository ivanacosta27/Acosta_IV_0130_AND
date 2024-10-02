package com.acosta.menu

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        findViewById<ImageView>(R.id.hamburgerButton).setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_first -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AnotherFragment())
                        .addToBackStack(null)
                        .commit()
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_second -> {
                    showDialogFragment()
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_exit -> {
                    finishAffinity()
                    true
                }
                else -> false
            }
        }
    }

    private fun showDialogFragment() {
        AlertDialog.Builder(this)
            .setTitle("PICK ONE")
            .setMessage("What to do?")
            .setPositiveButton("To Another Fragment") { _, _ ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AnotherFragment())
                    .addToBackStack(null)
                    .commit()
            }
            .setNegativeButton("EXIT") { _, _ ->
                finishAffinity()
            }
            .show()
    }

}
