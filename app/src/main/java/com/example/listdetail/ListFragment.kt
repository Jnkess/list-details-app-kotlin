package com.example.listdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment(R.layout.fragment_list) {

    companion object {
        fun newInstance(type: String): ListFragment {
            val fragment = ListFragment()
            val args = Bundle()
            args.putString("type", type)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val type = this.arguments?.getString("type")
        var dishes = arrayOf(
            "Pomidorowa 1", "Schab 2", "Rosół 3", "Naleśniki 4", "Barszcz 5",
            "Jajecznica 6", "Grochowa 7", "Zrazy 8",
        )

        when (type) {
            "soup" -> dishes = getSoups(dishes)
            "dish" -> dishes = getDishes(dishes)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerAdapter(dishes)
    }

    private fun getDishes(types: Array<String>): Array<String> {
        val list = mutableListOf<String>()
        types.forEachIndexed{ i, v -> if (i%2==0) list.add(v)}
        return list.toTypedArray()
    }

    private fun getSoups(types: Array<String>): Array<String> {
        val list = mutableListOf<String>()
        types.forEachIndexed{ i, v -> if (i%2==1) list.add(v)}
        return list.toTypedArray()
    }
}