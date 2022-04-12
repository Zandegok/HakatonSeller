package com.example.bf_kotlin_client.adapters.farmers

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.databinding.*
import com.example.bf_kotlin_client.dtos.entities.Farmer
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.FarmerFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.*

class RvAdapterFarmers(private var farmers: ArrayList<Farmer>) :
    RecyclerView.Adapter<RvAdapterFarmers.ViewHolder>() {

    private var imageApiWorker = ImagesApiWorker()
    private var fragmentManager = GlobalVariables.instance.fragmentManager

    inner class ViewHolder internal constructor(var binding: FarmersItemPreviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ViewModel {

        var fieldImage: ObservableField<Bitmap> = ObservableField(
            imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background)
        )
            private set
        var farmer = Farmer()
            set(value) {
                field = value
                GlobalScope.launch(Dispatchers.IO) {
                    var bitmap =
                        imageApiWorker.getPictureByName("farmers", value.photoPath)
                    fieldImage.set(bitmap)
                }
            }

        fun openFarmerFragment() {
            fragmentManager.openFragmentAboveMain(FarmerFragment)
            var binding = fragmentManager.getCurrentFragmentBinding<FragmentFarmerBinding>()
            var viewModel = binding!!.viewModel
            viewModel!!.farmer = farmer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = FarmersItemPreviewBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.farmers_item_preview, parent, false)
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = ViewModel()
        holder.binding.viewModel!!.farmer = farmers[position]
    }

    override fun getItemCount(): Int {
        return farmers.size
    }

}
