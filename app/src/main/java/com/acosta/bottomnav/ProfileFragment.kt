package com.acosta.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment


class ProfileFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var checkboxSports: CheckBox
    private lateinit var checkboxMusic: CheckBox
    private lateinit var checkboxTravel: CheckBox
    private lateinit var buttonEdit: Button
    private lateinit var buttonSave: Button

    private var isEditing = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        editTextName = view.findViewById(R.id.editTextName)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        radioGroupGender = view.findViewById(R.id.radioGroupGender)
        checkboxSports = view.findViewById(R.id.checkboxSports)
        checkboxMusic = view.findViewById(R.id.checkboxMusic)
        checkboxTravel = view.findViewById(R.id.checkboxTravel)
        buttonEdit = view.findViewById(R.id.buttonEdit)
        buttonSave = view.findViewById(R.id.buttonSave)


        setEditableState(false)

        buttonEdit.setOnClickListener {
            isEditing = true
            setEditableState(true)
        }

        buttonSave.setOnClickListener {
            isEditing = false
            setEditableState(false)
        }

        return view
    }

    private fun setEditableState(isEditable: Boolean) {
        editTextName.isEnabled = isEditable
        editTextEmail.isEnabled = isEditable
        checkboxSports.isEnabled = isEditable
        checkboxMusic.isEnabled = isEditable
        checkboxTravel.isEnabled = isEditable

        buttonEdit.visibility = if (isEditable) View.GONE else View.VISIBLE
        buttonSave.visibility = if (isEditable) View.VISIBLE else View.GONE
    }
}
