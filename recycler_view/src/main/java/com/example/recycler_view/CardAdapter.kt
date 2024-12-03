import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.Elemento
import com.example.recycler_view.databinding.ActivityCardBinding

// Parametro lista elementos
class CardAdapter(private val listaElementos: List<Elemento>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    // crea y devuelve binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ActivityCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    // Rellena la vista
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val elemento = listaElementos[position]
        holder.binding.image.setImageResource(elemento.image)
        holder.binding.titulo.text = elemento.titulo
        holder.binding.descripcion.text = elemento.descripcion
    }

    // Obligatorio pero no necesario
    override fun getItemCount(): Int {
        return listaElementos.size
    }

    // Extraible, se quedaría igual + imports
    inner class CardViewHolder(val binding: ActivityCardBinding) : RecyclerView.ViewHolder(binding.root)
}
