package com.example.hw_maks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw_maks.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    var click = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        binding.minus.visibility = View.GONE;

    }

    private fun initListener() {
        binding.plus.setOnClickListener(View.OnClickListener {
            binding.zero.text = click.toString()
            click++
            if (click == 10) {
                binding.plus.visibility = View.GONE
                binding.minus.visibility = View.VISIBLE
            }
        })

        binding.minus.setOnClickListener(View.OnClickListener {
            binding.zero.text = click.toString()
            click--
            if (click == -1) {
                val bundle = Bundle()
                bundle.putString("name", binding.etData.text.toString())

                val fragment = SecondFragment()
                fragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.icontainer, SecondFragment()).addToBackStack(null).commit()
            }
        })


    }
}