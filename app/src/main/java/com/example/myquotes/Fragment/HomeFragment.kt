package com.example.myquotes.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myquotes.R
import com.example.myquotes.databinding.FragmentHomeBinding
import com.example.quotesapp.Adapter.QuotesAdapter
import com.example.quotesapp.Model.QuotesModel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

lateinit var homeBinding: FragmentHomeBinding

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        homeBinding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )// Inflate the layout for this fragment

        val quotes = arrayOf(
            "A smile is happiness you'll find right under your nose...",
            "Because of your smile, you make life more beautiful...",
            "A smile is the best makeup any girl can wear...",
            "I am not getting better but at" + "Least I haven’t killed myself...",
            "“I’m constantly in awe of the work ethic of the human heart It keeps beating though it’s broken...”",
            "“But love has a way of revealing itself in the most explicit manner...",
            "Peril, loneliness, an uncertain future, are not oppressive...",
            "Music was my refuge. I could crawl into the space between...",
            "All I ever wanted was to reach out and touch another human being...",
            "I would rather sit on a pumpkin and have it all to myself, than be...",
            "I wish I could show you when you are lonely or in darkness...",
            "To live is the rarest thing in the world. Most people exist, that is all...",
            "That it will never come again is what makes life so sweet...",
            "Be kind, for everyone you meet is fighting a hard battle...",
            "Love is patient, love is kind. It does not envy, it does not boast...",
            "Have enough courage to trust love one more time and always one more time...",
            "A happy person is not a person in a certain set of circumstances...",
            "Anger is always more harmful than the insult that caused it...",
            "A fool gives full vent to his anger, but a wise man keeps himself under control...",
            "We can shoot rockets into space but we can’t cure anger or discontent...",
            "Read, read, read. Read everything – trash, classics, good and bad...",
            "A good writer possesses not only his own spirit but also...",
            " Anger makes you smaller, while forgiveness forces you to grow beyond what you were...",
        )

        val quotesList = ArrayList<QuotesModel>()

        for (i in quotes.indices) {
            val quote = QuotesModel(quotes[i])
            quotesList.add(quote)
        }


        var adapter = QuotesAdapter(requireContext(), quotesList)
        val lm = GridLayoutManager(requireContext(), 1)
        homeBinding.Rvdata.layoutManager = lm
        homeBinding.Rvdata.adapter = adapter



        return homeBinding.root
    }


}