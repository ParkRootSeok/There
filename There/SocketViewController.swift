//
//  SocketViewController.swift
//  There
//
//  Created by 양채연 on 2022/07/01.
//

import UIKit

class SocketViewController: UIViewController {
    
    @IBOutlet weak var textField: UITextField!
    var socket: SocketIOClient!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBOutlet func disconnectSocket(_ sender: Any) {
        SocketIOManager.shared.closeConnection()
    }
    @IBOutlet func connectSocket(_ sender: Any) {
        SocketIOManager.shared.establishConnection()
    }
    @IBAction func sendData(_ sender: Any) {
        SocketIOManager.shared.sendMessage(message: self.textField.text, nickname: "samsic")
    }
    
}
