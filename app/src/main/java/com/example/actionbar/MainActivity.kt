package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.app.NavUtils
import com.example.actionbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar

        actionBar!!.title = "  Action Bar"

        actionBar.subtitle = "  Design a custom Action Bar"

        actionBar.setIcon(R.drawable.ic_tarta_d_queso)

        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true) //para volver a casa
        registerForContextMenu(binding.tvHelloWorld)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itOption1 -> {
                Snackbar.make(binding.root, "Necesito una cerveza", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.itOption2 -> {
                Snackbar.make(binding.root, "Necesito un descanso", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.itOption3 -> {
                Snackbar.make(binding.root, "Necesito un paseo", Snackbar.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.search)
            NavUtils.navigateUpTo(this, Intent(this, ItemListActivity::class.java))


        when (item.itemId) {
            R.id.search -> Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
            R.id.refresh -> Toast.makeText(this, "Refresh Clicked", Toast.LENGTH_SHORT).show()
            R.id.copy -> Toast.makeText(this, "Copy Clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.tvHelloWorld){
            menuInflater.inflate(R.menu.contextual_menu, menu)
        }
    }
}