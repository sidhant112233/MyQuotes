package com.example.myquotes.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.R
import com.example.myquotes.databinding.FragmentLikeBinding
import com.example.quotesapp.Adapter.QuotesAdapter
import com.example.quotesapp.Model.QuotesModel


lateinit var likeBinding: FragmentLikeBinding
class LikeFragment : Fragment() {

    private lateinit var quotesList: ArrayList<QuotesModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        likeBinding = FragmentLikeBinding.inflate(inflater,container,false)// Inflate the layout for this fragment
        var view =inflater.inflate(R.layout.like_view,container,false)

        quotesList = ArrayList()

        var recyclerView = view.findViewById<RecyclerView>(R.id.Rvlikedata)
        var adapter = QuotesAdapter(requireContext(),quotesList)



        return likeBinding.root
    }

}