package com.example.amtoon.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.amtoon.MangaitemAdapter
import com.example.amtoon.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import mangaitemdataclass

class Favourites : Fragment() {

    private lateinit var dbrefong: DatabaseReference
    private lateinit var dbrefongurl: DatabaseReference
    private val mangadatalist = mutableListOf<mangaitemdataclass>()
    private lateinit var mangarecycler: RecyclerView
    private lateinit var adaptertwo: MangaitemAdapter
    private var userType : String = "best_action_manhwa"

    var url1: String? = null
    var url2: String? = null
    var url3: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.mangafragment, container, false)

        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        val imageList = ArrayList<SlideModel>() // Create image list
        val mangatypeArray = resources.getStringArray(R.array.mangatypearray)
        //Example of setting up a spinner
        val spinner: Spinner = view.findViewById(R.id.spinner)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, mangatypeArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        // Inflate the layout for this fragment
        mangarecycler = view.findViewById(R.id.mangarecycler)
        mangarecycler.setHasFixedSize(true)
        mangarecycler.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        adaptertwo = MangaitemAdapter(mangadatalist)
        mangarecycler.adapter = adaptertwo

        dbrefongurl = FirebaseDatabase.getInstance().getReference("urls")
        dbrefongurl.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Assign URLs to variables
                    url1 = dataSnapshot.child("url1").getValue(String::class.java)
                    url2 = dataSnapshot.child("url2").getValue(String::class.java)
                    url3 = dataSnapshot.child("url3").getValue(String::class.java)

                    imageList.clear()

                    url1?.let { imageList.add(SlideModel(it)) }
                    url2?.let { imageList.add(SlideModel(it)) }
                    url3?.let { imageList.add(SlideModel(it)) }

                    // Set the image list to the slider
                    imageSlider.setImageList(imageList)
                } else {
                    Log.d("FirebaseURL", "No URLs found in the 'urls' node.")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("FirebaseURL", "Failed to read URLs", databaseError.toException())
            }
        })
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Get the selected item as a string
                val selectedItem: String = spinner.selectedItem.toString() // This will return the selected item as a String
                Log.d("SelectedSpinnerItem", selectedItem) // Log the selected item (optional)

                // You can now use the selectedItem as needed
                getuserdataong(selectedItem) // Fetch data based on the selected user type
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Optional: Handle the case where no item is selected if necessary
            }
        }



        getuserdataong(userType)
        return view
    }

    private fun getuserdataong(userType : String) {
        dbrefong = FirebaseDatabase.getInstance().getReference(userType)
        dbrefong.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mangadatalist.clear()
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val event = userSnapshot.getValue(mangaitemdataclass::class.java)
                        event?.let { mangadatalist.add(it) }
                    }
                    adaptertwo.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error if needed
            }
        })
    }
}
