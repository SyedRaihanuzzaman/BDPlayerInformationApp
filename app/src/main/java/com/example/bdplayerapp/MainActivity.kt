package com.example.bdplayerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bdplayerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Model>
    lateinit var imgId:Array<Int>
    lateinit var tittleId:Array<String>
    lateinit var ppositionId:Array<String>
    lateinit var playerinfo:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate((layoutInflater))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        imgId = arrayOf(
            R.drawable.sakibalhasan,
            R.drawable.tamimiqbal,
            R.drawable.mominulhaque,
            R.drawable.litondas,
            R.drawable.zakirhasan,
            R.drawable.nazmulshanto,
            R.drawable.towhidhridoy,
            R.drawable.afifhossain,
            R.drawable.yasirali,
            R.drawable.mustafiz,
            R.drawable.mehedimiraz,
            R.drawable.shorifulislam
        )

        tittleId = arrayOf(
            "Shakib Al Hasan","Tamim Iqbal","Mominul Haque","Liton Das","Zakir Hasan","Najmul Hossain Shanto","Towhid Hridoy","Afif Hossain",
            "Yasir Ali","Mustafizur Rahman","Mehidy Hasan Miraz","Shoriful Islam"
        )

        ppositionId = arrayOf(
            "Left-handed Allrounder","Left-handed Batsman","Left-Handed Batsman","Right-Handed Batsman","Right-Handed Batsman",
            "Left-Handed Batsman","Right-Handed Batsman","Left-Handed Batsman","Right-Handed Batsman","Left-Handed Fast Bowler","Right-Handed Allrounder",
            "Left-Handed Fast Bowler"
        )

        playerinfo = arrayOf(

            getString(R.string.SakibAlHasan),
            getString(R.string.TamimIqbal),
            getString(R.string.MominulHaque),
            getString(R.string.LitonDas),
            getString(R.string.ZakirHasan),
            getString(R.string.NazmulHasanShanto),
            getString(R.string.TowhidHridoy),
            getString(R.string.AfifHossain),
            getString(R.string.YasirAli),
            getString(R.string.MustafizurRahman),
            getString(R.string.MehidyHasanMiraz),
            getString(R.string.ShorifulIslam)
        )

        newRecyclerView = findViewById(R.id.recycleid)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Model>()
        getdata()


    }

    private fun getdata() {
        for(i in imgId.indices){
            val model = Model(imgId[i],tittleId[i],ppositionId[i])
            newArrayList.add(model)
        }

        var adapter = Adapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object:Adapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity,playerInformation::class.java)

                intent.putExtra("tittle",newArrayList[position].playertittle)
                intent.putExtra("img",newArrayList[position].playerimage)
                intent.putExtra("information",playerinfo[position])
                startActivity(intent)

            }

        })
    }
}