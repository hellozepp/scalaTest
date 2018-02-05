

class SecondarySortKey(val first:Int,val second:Int)extends Ordered[SecondarySortKey] with Serializable{
  override def compare(other: SecondarySortKey): Int = {
    if(this.first>other.first||(this.first==other.first&&this.second>other.second)){
      return  1;
    }
    else if(this.first<other.first||(this.first==other.first&&this.second<other.second)){
      return -1;
    }

    return 0;
  }

}
