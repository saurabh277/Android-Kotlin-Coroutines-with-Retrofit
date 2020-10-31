package com.example.kotlincoroutinewithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutinewithretrofit.Adapter.PostAdapter
import com.example.kotlincoroutinewithretrofit.Model.Post
import com.example.kotlincoroutinewithretrofit.Repository.PostRepository
import com.example.kotlincoroutinewithretrofit.ViewModel.PostViewModel
import com.example.kotlincoroutinewithretrofit.ViewModel.postViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
      val postRepository=PostRepository()
        val viewModelFactory= postViewModelFactory(postRepository)
        postViewModel=ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<Post>)
            progressBar.visibility= View.GONE
            recyclerView.visibility=View.VISIBLE
        })
    }

    private fun initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        postAdapter= PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }
}
