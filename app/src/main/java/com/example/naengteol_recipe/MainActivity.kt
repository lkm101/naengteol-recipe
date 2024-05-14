package com.example.naengteol_recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.naengteol_recipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavi.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_refrigerator -> {
                    setFrag(0)
                }
                R.id.action_recipe -> {
                    setFrag(1)
                }
                R.id.action_bookmark -> {
                    setFrag(2)
                }
                R.id.action_setting -> {
                    setFrag(3)
                }
                else -> {
                    false
                }
            }
        }
        setFrag(0)
    }

    private fun setFrag(fragNum : Int) : Boolean {
        val ft = supportFragmentManager.beginTransaction()

        when(fragNum){
            0 -> {
                ft.replace(R.id.main_frame, RefrigeratorFrag()).commit()
            }
            1 -> {
                ft.replace(R.id.main_frame, RecipeFrag()).commit()
            }
            2 -> {
                ft.replace(R.id.main_frame, BookmarkFrag()).commit()
            }
            3 -> {
                ft.replace(R.id.main_frame, SettingFrag()).commit()
            }
        }
        return true
    }
}