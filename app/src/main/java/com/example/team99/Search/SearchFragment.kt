package com.example.team99.Search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team99.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val searchVideoViewModel: SearchVideoViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Adapter setup
        searchAdapter = SearchAdapter()
        binding.rvSearchResult.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = searchAdapter
        }

        // LiveData observers
        searchVideoViewModel.searchResult.observe(viewLifecycleOwner, Observer { videos ->
            searchAdapter.submitList(videos)
        })

        searchVideoViewModel.errorMessage.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        })

        // Ensure isLoading LiveData is observed to show/hide a ProgressBar (if implemented)
        searchVideoViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        // EditText listener for IME action
        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (binding.etSearch.text.toString().trim().isNotEmpty()) {
                    searchVideoViewModel.searchVideos(binding.etSearch.text.toString().trim())
                    hideKeyboard(binding.etSearch)
                } else {
                    Toast.makeText(context, "검색어를 입력하세요.", Toast.LENGTH_SHORT).show()
                }
                true
            } else {
                false
            }
        }
    }

    private fun hideKeyboard(view: View) {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
