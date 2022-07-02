//
//  IntroCollectionViewCell.swift
//  There
//
//  Created by 이민아 on 2022/07/02.
//

import UIKit

class IntroCollectionViewCell: UICollectionViewCell {
    static let identifier = "IntroCollectionViewCell"
    
    @IBOutlet weak var introLabel: UILabel!
    self.introLabel.numberOfLines = 0 //자동줄바꿈
    
    @IBOutlet weak var introView: UIView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        introView.layer.cornerRadius = 88 / 2
        introView.layer.borderColor = UIColor.darkGray.cgColor
        introView.layer.borderWidth = 1
    }

}
