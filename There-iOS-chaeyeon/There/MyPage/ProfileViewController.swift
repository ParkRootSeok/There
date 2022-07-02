//
//  ProfileViewController.swift
//  There
//
//  Created by 이민아 on 2022/07/01.
//

import UIKit

class ProfileViewController: UIViewController {

    @IBOutlet var profileCollectionView: UICollectionView!
    
    @IBOutlet var postButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupCollectionView()
        
        //기록하기 버튼 속성
        postButton.layer.cornerRadius = 5
        postButton.layer.borderColor = UIColor.lightGray.cgColor
        postButton.layer.borderWidth = 1
        
    }
    
    private func setupCollectionView(){
        //delegate 연결
        profileCollectionView.delegate = self
        profileCollectionView.dataSource = self
        
        //profile cell 등록
        profileCollectionView.register(UINib(nibName: "ProfileCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: ProfileCollectionViewCell.identifier)
        
        //intro cell 등록
                profileCollectionView.register(UINib(nibName: "IntroCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: IntroCollectionViewCell.identifier)
        
        //post cell 등록
        profileCollectionView.register(UINib(nibName: "PostCollectionViewCell", bundle: nil), forCellWithReuseIdentifier: PostCollectionViewCell.identifier)
        
        
        
    }
    
    @IBAction func postPressed(_ sender: Any) {
        //posting 화면으로 전환
    }
    
}


extension ProfileViewController: UICollectionViewDelegate, UICollectionViewDataSource{
    //section 개수: 3개 (profile, introduction, post)
    func numberOfSections(in collectionView: UICollectionView) -> Int {
        return 3
    }
    
    //cell의 갯수
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        switch section{
        case 0: //profile
            return 1
        case 1: //introduction
            return 1
        default: //post
            return 24
        }
    }
    
    //cell 생성
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let section = indexPath.section
        switch section{
        case 0:
            guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: ProfileCollectionViewCell.identifier, for: indexPath)
                        as? ProfileCollectionViewCell else {
                            fatalError("셀 타입 캐스팅 실패")
                        }
                return cell
        case 1:
            guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: IntroCollectionViewCell.identifier, for: indexPath)
                        as? IntroCollectionViewCell else {
                            fatalError("셀 타입 캐스팅 실패")
                        }
                return cell
        default:
            guard let cell = collectionView.dequeueReusableCell(withReuseIdentifier: PostCollectionViewCell.identifier, for: indexPath)
                        as? PostCollectionViewCell else {
                            fatalError("셀 타입 캐스팅 실패")
                        }
                return cell
        }
       
    }
}

extension ProfileViewController: UICollectionViewDelegateFlowLayout{
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let section = indexPath.section
        switch section {
        case 0:
            return CGSize(width: collectionView.frame.width, height: CGFloat(159))
        case 1:
            return CGSize(width: collectionView.frame.width, height: CGFloat(150))
        default:
            let side = CGFloat((collectionView.frame.width /3)-(4/3))
            return CGSize(width: side, height: side)
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        switch section{
        case 0:
            return CGFloat(0)
        case 1:
            return CGFloat(0)
        default:
            return CGFloat(1)
        }
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        switch section{
        case 0:
            return CGFloat(0)
        case 1:
            return CGFloat(0)
        default:
            return CGFloat(1)
        }
    }
}
