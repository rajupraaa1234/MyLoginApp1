package com.example.myloginapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class FragmentActivity : AppCompatActivity() {

    var LoginFrag : Login = Login()
    var SignUpFrag : SignUp = SignUp()
    lateinit var CurrentFrag : Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        if(savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment,LoginFrag)
                .commitAllowingStateLoss()
            CurrentFrag = LoginFrag
        }
    }

    fun onClickHandler(view : View){
        when(view.id){
            R.id.loginbtn->{
                addFragment(LoginFrag,true)
                true
            }
            R.id.singupbtn->{
                addFragment(SignUpFrag,true)
                true
            }
        }
    }


    fun addFragment(fragment: Fragment, isBackStack: Boolean) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment.isAdded) {
            return  //or return false/true, based on where you are calling from
        }
        transaction.replace(R.id.fragment, fragment)
        if (isBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}