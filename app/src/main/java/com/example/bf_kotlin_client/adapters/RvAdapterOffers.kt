package com.example.bf_kotlin_client.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.databinding.FragmentEditOfferBinding
import com.example.bf_kotlin_client.databinding.OfferPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables

/**
 * Класс, отрисовывающий список предложений
 *
 * @property offers отрисовываемый списо
 *
 */
class RvAdapterOffers(private var offers: ArrayList<Offer>) :
    RecyclerView.Adapter<RvAdapterOffers.ViewHolder>() {
    private var fragmentManager = GlobalVariables.instance.fragmentManager

    /**
     * Контейнер, содержащий 1 карточку предложения
     * @property binding
     */
    inner class ViewHolder internal constructor(var binding: OfferPreviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    /**
     * Класс, обеспечивающий логику карточки предложения
     */
    inner class ViewModel {
        var offer= Offer()
        fun openEditOfferFragment() {
            fragmentManager.openFragmentAboveMain(AppFragmentManager.FragmentsName.EditOfferFragment)
            val binding = fragmentManager.getCurrentFragmentBinding<FragmentEditOfferBinding>()
            val viewModel = binding!!.viewModel!!
            viewModel.offer=offer
        }
    }

    /**
     * <*вызывается автоматически*>
     *
     * Метод, создающий карточку предложения
     *
     * @param parent форма, на которой происходит отрисовка
     * @param viewType *не используется*
     * @return держатель карточки предложения
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = OfferPreviewBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.offer_preview, parent, false)
        )
        return ViewHolder(binding)
    }

    /**
     * <*вызывается автоматически*>
     *
     * Метод, привязывающий логику к карточке предложения
     *
     * @param holder держатель карточки предложения
     * @param position индекс элемента в списке предложений
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = ViewModel()
        holder.binding.viewModel!!.offer = offers[position]
    }

    /**
     * Возвращает количество предложений
     *
     * @return колчество элементов в списке предложений
     */
    override fun getItemCount(): Int {
        return offers.size
    }

}
