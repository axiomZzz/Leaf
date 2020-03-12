package com.github.axiomzzz.leaf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_add_list.*

/**
 * A simple [Fragment] subclass.
 */
class AddListFragment : Fragment() {

   private val addListAdapter=AddListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerAddList.adapter=addListAdapter
        recyclerAddList.layoutManager=
            GridLayoutManager(this.context,3, GridLayoutManager.VERTICAL,false)
    }

    override fun onStart() {
        super.onStart()
        addListAdapter.startListening()

    }

    override fun onStop() {
        super.onStop()

        addListAdapter.stopListening()
    }

}
