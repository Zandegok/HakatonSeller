package com.example.bf_kotlin_client.adapters.support

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.databinding.*
import com.example.bf_kotlin_client.dtos.entities.Faq
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables
import java.util.ArrayList

class RvAdapterSupport(private var faqs: ArrayList<Faq>):
    RecyclerView.Adapter<RvAdapterSupport.ViewHolder>()  {

    private var globalVariables = GlobalVariables.instance
    private var fragmentManager = globalVariables.fragmentManager

    inner class ViewHolder internal constructor(var binding: SupportPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var faq = Faq()

        fun openSupportNotMainPageFragment() {
            fragmentManager.openFragmentAboveMain(AppFragmentManager.FragmentsName.SupportAnswersPageFragment)

            var binding =
                fragmentManager.getCurrentFragmentBinding<FragmentSupportAnswersPageBinding>()
            var viewModel = binding!!.viewModel
            viewModel!!.faq=faq
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapterSupport.ViewHolder {
        var binding = SupportPreviewBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.support_preview, parent, false))

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvAdapterSupport.ViewHolder, position: Int) {
        holder.binding.viewModel = holder
        holder.faq = faqs[position]
    }

    override fun getItemCount(): Int {
        return faqs.size
    }

}