//
//  MessageViewController.swift
//  There
//
//  Created by 양채연 on 2022/07/01.
//

import UIKit

class MessageViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    
    @IBAction func goChattingRoom(_ sender: Any) {
        //화면전환
        //스토리보드 생성
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        //뷰컨트롤러 생성
        let chatViewController = storyboard.instantiateViewController(withIdentifier: "ChatVC") as! ChatViewController
        
        //화면전환 메소드를 이용해서 화면을 전환
        self.navigationController?.pushViewController(chatViewController, animated: true)
    }
}
