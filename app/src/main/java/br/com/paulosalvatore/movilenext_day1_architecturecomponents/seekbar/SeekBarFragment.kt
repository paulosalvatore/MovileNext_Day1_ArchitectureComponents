package br.com.paulosalvatore.movilenext_day1_architecturecomponents.seekbar


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar

import br.com.paulosalvatore.movilenext_day1_architecturecomponents.R
import kotlinx.android.synthetic.main.fragment_seek_bar.*
import kotlinx.android.synthetic.main.fragment_seek_bar.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SeekBarFragment : Fragment() {

    private lateinit var seekBarViewModel: SeekBarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_seek_bar, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.let {
            seekBarViewModel =
                ViewModelProviders
                    .of(it)
                    .get(SeekBarViewModel::class.java)

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        seekBarViewModel.seekbarValue.value = progress
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            })

            seekBarViewModel.seekbarValue.observe(this, Observer { progress ->
                seekBar.progress = progress ?: 0
            })
        }
    }
}
