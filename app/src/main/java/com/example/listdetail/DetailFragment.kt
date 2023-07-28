package com.example.listdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.*
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var rotateOpen: Animation
    private lateinit var rotateClose: Animation
    private lateinit var fromBottom: Animation
    private lateinit var toBottom: Animation
    private lateinit var mainBtn: FloatingActionButton
    private lateinit var statBtn: FloatingActionButton
    private lateinit var timerBtn: FloatingActionButton
    private var clicked = false

    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var fragmentContainer: FragmentContainerView

    companion object {
        fun newInstance(type: String, description: String, imageId: Int): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putString("type", type)
            args.putString("description", description)
            args.putInt("imageId", imageId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView = view.findViewById<TextView>(R.id.detail_textview)
        val textView2 = view.findViewById<TextView>(R.id.detail_textview2)
        val imageView = view.findViewById<ImageView>(R.id.detailimage)
        textView3 = view.findViewById(R.id.detail_textview3)
        textView4 = view.findViewById(R.id.detail_textview4)
        fragmentContainer = view.findViewById(R.id.fragment_container3)

        textView.text = this.arguments?.getString("type")
        textView.text = textView.text.dropLast(1)
        textView2.text = this.arguments?.getString("description")
        val imageId = this.arguments?.getInt("imageId")
        val image = when (imageId){
            1 -> R.drawable.pomidorowa
            2 -> R.drawable.schab
            3 -> R.drawable.rosol
            4 -> R.drawable.nalesniki
            5 -> R.drawable.barszcz
            6 -> R.drawable.jajecznica
            7 -> R.drawable.grochowa
            else -> R.drawable.zrazy}
        imageView.setImageResource(image)

        parentFragmentManager.commit {
            setReorderingAllowed(true)
            add<StopWatchFragment>(
                R.id.fragment_container3,
                "SS",
                Bundle().apply { putString("type", textView.text.toString()) }
            )
        }
    }
}