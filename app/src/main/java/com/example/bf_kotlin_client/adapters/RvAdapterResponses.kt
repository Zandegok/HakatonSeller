package com.example.bf_kotlin_client.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.databinding.FragmentResponsePageBinding
import com.example.bf_kotlin_client.databinding.OfferResponcePreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Response
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables
/**
 * Класс, отрисовывающий список ответов на предложения
 *
 * @property offers отрисовываемый список
 *
 */
class RvAdapterResponses(private var responces: ArrayList<Response>) :
    RecyclerView.Adapter<RvAdapterResponses.ViewHolder>() {
    private var fragmentManager = GlobalVariables.instance.fragmentManager
    /**
     * Контейнер, содержащий 1 карточку ответа
     * @property binding
     */
    inner class ViewHolder internal constructor(var binding: OfferResponcePreviewBinding) :
        RecyclerView.ViewHolder(binding.root)
    /**
     * Класс, обеспечивающий логику карточки ответа
     */
    inner class ViewModel {

        var response = Response()

        fun openResponseFragment() {
            fragmentManager.openFragmentAboveMain(AppFragmentManager.FragmentsName.ResponsePage)
            val binding = fragmentManager.getCurrentFragmentBinding<FragmentResponsePageBinding>()
            val viewModel = binding!!.viewModel!!
            viewModel.response = response
        }
    }
    /**
     * <*вызывается автоматически*>
     *
     * Метод, создающий карточку ответа
     *
     * @param parent форма, на которой происходит отрисовка
     * @param viewType *не используется*
     * @return держатель карточки ответа
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = OfferResponcePreviewBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.offer_responce_preview, parent, false)
        )
        return ViewHolder(binding)
    }
    /**
     * <*вызывается автоматически*>
     *
     * Метод, привязывающий логику к карточке ответа
     *
     * @param holder держатель карточки ответа
     * @param position индекс элемента в списке ответов
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = ViewModel()
        holder.binding.viewModel!!.response = responces[position]
    }
    /**
     * Возвращает количество ответов
     *
     * @return колчество элементов в списке ответов
     */
    override fun getItemCount(): Int {
        return responces.size
    }
}

