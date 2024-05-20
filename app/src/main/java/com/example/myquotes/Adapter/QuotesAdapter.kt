package com.example.quotesapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myquotes.R
import com.example.quotesapp.Model.QuotesModel


class QuotesAdapter(val context: Context, val quotesList: ArrayList<QuotesModel>):
    RecyclerView.Adapter<QuotesAdapter.QuotesHolder>() {


    class QuotesHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var txtquotes: TextView = itemView.findViewById(R.id.txtquotes)
        var share: ImageView = itemView.findViewById(R.id.share)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quotes_view,parent,false)
        return QuotesHolder(view)
    }

    override fun onBindViewHolder(holder: QuotesHolder, position: Int) {
       holder.txtquotes.text = quotesList[position].quotes
        holder.share.setImageResource(R.drawable.share)

        holder.share.setOnClickListener {
            var txtquotes = quotesList[position].quotes
            var shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "type/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,txtquotes)
            holder.itemView.context.startActivity(Intent.createChooser(shareIntent,"share using"))
        }

    }

    override fun getItemCount(): Int {

        return quotesList.size

    }

}
