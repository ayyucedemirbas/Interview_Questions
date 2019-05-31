package LinkedList;

// Soru:  https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1
// Soruda bagli listenin int tipinde olmasi isteniyor. Bu ornek char tipinde bir liste ile yazildi
// Listenin tipi ve input degerleri degistirilerek soruda istenildigi gibi sayi degerleri siralanabilir

public class LinkedList {
	
	Karakter head;  //Bagli listenin basi
	
	class Karakter{//Dugumler Karakter olarak isimlendirildi
		char c;//Her bir dugumun verisi char tipinde olacak
		Karakter next; //Bir sonraki eleman ile baglantiyi saglamak icin
		Karakter(char c){//constructor metot
			this.c=c;
			next=null;
		}
	}
	
	Karakter sonuBul(Karakter baslangic) { //En son elemani bulmak icin
		while(baslangic.next != null) {
			baslangic=baslangic.next;
		}
		return baslangic;
	}
	
	void basaEkle(char key) {
		Karakter k= new Karakter(key);
		k.next=head;
		head=k;
	}
	
	void arayaEkle(char key, Karakter prev) {
		if(prev!=null) {
		Karakter k= new Karakter(key);
		k.next=prev.next;
		prev.next=k;
		}
		
	}
	
	void sonaEkle(char key) {
		Karakter k= new Karakter(key);
		if(head==null) {
			head=new Karakter(key);
			return;
		}
		
		k.next=null;
		
		Karakter last=sonuBul(head);
		
	
		last.next=k;
		return;
	}
	
	
	Karakter middle(Karakter h)  { //Bagli listenin ortasindaki dugumu geri donecek
        Karakter slow_ptr = h; 
        Karakter fast_ptr = h.next; 
        if (h != null) 
        { 
            while (fast_ptr != null && fast_ptr.next != null) 
            { 
                fast_ptr = fast_ptr.next.next; 
                slow_ptr = slow_ptr.next; 
            } 
            
            
        } 
        return slow_ptr;
    } 

	

    Karakter sortedMerge(Karakter a, Karakter b)  { 
    	Karakter result = null; 
        /* Recursive metodun base case'i */
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
  
        /* char degiskenlerin ascii degerlerini kontrol et */
        if (a.c <= b.c) { 
            result = a; 
            result.next = sortedMerge(a.next, b); 
        } 
        else { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
    } 
  
   Karakter mergeSort(Karakter h) { // (recursive metot oldugu icin bu islemler her adimda yapacak)
        //head yani bas = null ise program null donup sonlanacak
        if (h == null || h.next == null) { 
            return h; 
        } 
        
  
        /* merge sort yapabilmek icin bagli listenin ortadaki elenanini bulmamiz gerekiyor */
        Karakter ortadaki = middle(h); 
        
        // ortadaki elemanin next'ini kaybetmemek icin yedekliyoruz
        Karakter nextofmiddle = ortadaki.next; 
  
        /* yedekleme isleminden sonra, listenin sadece yarisi ile calisacagimiz icin ortadaki
         * elemanin next'ini null yaparak listenin yarisini silmis olduk*/
        ortadaki.next = null; 
  
        // geriye kalan listeyi siraladik
        Karakter ilkListe = mergeSort(h); 
  
        // yedekledigimiz listeyi siraladik 
        Karakter yedeklenenListe = mergeSort(nextofmiddle); 
  
        // ilk liste ve yedeklenen listenin her ikisinin de elemanlari siralaniyor 
        Karakter sortedlist = sortedMerge(ilkListe, yedeklenenListe); 
        return sortedlist; 
    } 
   
   
   
   /*	void bastanSil(Karakter baslangic) {
	if(head==null) {return;}
	Karakter son=sonuBul(baslangic);
	if(head==son) {
		head=null; son=null;
	}
	
	
	
	head=head.next;
	
}*/
	
	/*void sondanSil() {
		Karakter son= sonuBul(head);
		Karakter tmp, prev;
		tmp=head;
		prev=null;
		while(tmp!=son) {
			prev=tmp;
			tmp=tmp.next;
		}
		
		if(prev==null) {
			head=null;
		}
		else {
			prev.next=null;
		}
		son=prev;

       
	}

	void aradanSil(int konum) {
		if(head==null) {return;}
		Karakter temp=head;
		if(konum==0) {head=temp.next; return;}
		for(int i=0; temp!=null&&i<konum-1;i++) {
			temp=temp.next;
		}
		
		if(temp==null||temp.next==null) {return;}
		
		Karakter next=temp.next.next;
		temp.next=next;
	}*/
	
   
   
   
	void printList(Karakter bas) {
		while (bas!=null) {
			System.out.println(bas.c);
			bas=bas.next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList cl= new LinkedList();
		cl.basaEkle('b');
		cl.basaEkle('h');
		cl.basaEkle('a');
		cl.basaEkle('t');
		cl.arayaEkle('j', cl.head.next);
		cl.sonaEkle('e');
		cl.basaEkle('q');
		cl.basaEkle('z');
		cl.basaEkle('x');
		cl.basaEkle('v');
	
		System.out.println("Siralanmamis liste:");
		cl.printList(cl.head);
		System.out.println("Siralanmis liste:");
		cl.head=cl.mergeSort(cl.head); // zaman karmasikligi: O(n logn)
		cl.printList(cl.head);
	
		// yararlanilan kaynaklar https://www.geeksforgeeks.org/merge-sort-for-linked-list/
	}

}